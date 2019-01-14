package store.ae.server.couplet;

import java.util.Date;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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
import store.ae.server.core.Config;

public class ServerHandler extends ChannelInboundHandlerAdapter {
	
	private WebSocketServerHandshaker handshaker;
	
	private static final String WEB_SOCKET_URL = "ws://localhost:8888/websocket";
		  
	/**
     * 客户端与服务端创建连接的时候调用
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client link server start...");
        Config.group.add(ctx.channel());
    }
 
    /**
     * 客户端与服务端断开连接时调用
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client link server close...");
        Config.group.remove(ctx.channel());
    }
 
    /**
     * 服务端接收客户端发送过来的数据结束之后调用
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        System.out.println("Message is recieved...");
    }
 
    /**
     * 工程出现异常的时候调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
 
    /**
       *  服务端处理客户端websocket请求的核心方法，这里接收了客户端发来的信息
     */
    @Override
	public void channelRead(ChannelHandlerContext context, Object msg) throws Exception {
    	
    	// 处理客户端向服务端发起http握手请求的业务
    	if(msg instanceof FullHttpRequest) {
    		handHttpRequest(context, (FullHttpRequest) msg);
    	}else if(msg instanceof WebSocketFrame) {
    		// 处理websocket连接业务
    		handWebsocketFrame(context, (WebSocketFrame) msg);
    	}
    	
    	// System.out.println("I'm server, I'm recieved：" + ((serverInfo) msg).getInfo());
    	// 服务端使用这个就能向 每个连接上来的客户端群发消息
    	// Config.group.writeAndFlush(msg);
    	// Iterator<Channel> iterator = Config.group.iterator();
    	// while(iterator.hasNext()){
    		// 打印出所有客户端的远程地址
    		// System.out.println((iterator.next()).remoteAddress());
    	// }
    	// 单独回复客户端信息
    	// channelHandlerContext.writeAndFlush(info);
    }
    
    /**
     * 处理客户端与服务端之间的websocket业务
     * @param ctx
     * @param frame
     */
    private void handWebsocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
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
    	Config.group.writeAndFlush(tws);
    }
    
    /**
     * 处理客户端向服务端发起http握手请求的业务
     * @param ctx
     * @param req
     */
	private void handHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
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
    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
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
