	package store.ae.agent;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 接收/处理/响应客户端websocket请求的核心业务处理类
 * @author sidtadpole
 *
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
		 
	    @Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	        System.out.println("我是客户端：" +msg);
	    }
	    
	    @Override
	    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	        System.out.println("通道读取完毕！");
	    }
	    
	    @Override
	    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
	        if(null != cause) cause.printStackTrace();
	        if(null != ctx) ctx.close();
	    }
}
