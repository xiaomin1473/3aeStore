package store.ae.server.core;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;
import store.ae.server.common.ConfigUtil;

public class Handler {

	
	private WebSocketServerHandshaker handshaker;
	
	private static final String WEB_SOCKET_URL = "ws://localhost:8888";
    /**
     * 处理客户端与服务端之间的websocket业务
     * @param ctx
     * @param frame
     */
    public void handWebsocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
    	// 判断是否是关闭websocket指令
    	if(frame instanceof CloseWebSocketFrame) {
    		handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
    	}
    	// 判断是ping消息
    	if(frame instanceof PingWebSocketFrame) {
    		ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
    		return;
    	}
    	// 判断是否是二进制消息，如果是二进制消息，则抛出异常
    	if(!(frame instanceof TextWebSocketFrame)) {
    		System.out.println("目前不支持二进制消息");
    		throw new RuntimeException("【" + this.getClass().getName() + "】不支持消息");
    	}
    	
    	// 返回应答消息
    	String request = ((TextWebSocketFrame) frame).text();
    	
    	System.out.println("服务端收到客户端的消息 =====>>>>" + request);
    	
    	TextWebSocketFrame tws =new TextWebSocketFrame(new Date().toString() + 
										    			ctx.channel().id() + 
										    			"===>>> " + 
										    			request);
    	// 群发，服务端向每个连接上来的客户端群发消息
    	ConfigUtil.group.writeAndFlush(tws);
    }
    
    /**
     * 处理客户端向服务端发起http握手请求的业务
     * @param ctx
     * @param req
     */
    public void handHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
		if(!req.decoderResult().isSuccess() || !("websocket".equals(req.headers().get("Upgrade")))) {
			sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
			return;
		}
		WebSocketServerHandshakerFactory wsfaFactory = new WebSocketServerHandshakerFactory(WEB_SOCKET_URL, null, false);
	
		handshaker =wsfaFactory.newHandshaker(req);
		if(handshaker == null) {
			WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
		} else {
			handshaker.handshake(ctx.channel(), req);
		}
	}
    
    /**
     * 
     * 服务端向客户端响应消息
     * @param ctx
     * @param req
     * @param res
     */
    public void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
    	if(res.status().code() != 200) {
    		ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
    		res.content().writeBytes(buf);
    		buf.release();
    	}
    	
    	// 服务端向客户发送数据
    	ChannelFuture future = ctx.channel().writeAndFlush(res);
    	
    	if(res.status().code() != 200) {
    		future.addListener(ChannelFutureListener.CLOSE);
    	}
    }
}
