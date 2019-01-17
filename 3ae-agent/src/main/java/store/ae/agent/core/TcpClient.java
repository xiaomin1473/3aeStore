package store.ae.agent.core;

import java.text.SimpleDateFormat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@Sharable
public class TcpClient extends SimpleChannelInboundHandler<Object> {
	
	@SuppressWarnings("unused")
	private String CLIENT_INFO = "【客户端】";
	
	private String getTime() {
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return time.format(System.currentTimeMillis());
	}
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		System.out.println("【连接信息】 " + ctx);
		System.out.println("【建立时间】" + getTime());
		System.out.println("【客户管理】已与服务端 " + ctx.channel().remoteAddress() + " 建立连接!");
		
		ctx.writeAndFlush(Unpooled.copiedBuffer("@@**228888^....A##",
		        CharsetUtil.UTF_8));
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf in = (ByteBuf) msg;
		
		System.out.println("\n【新短消息】" + ctx.channel().remoteAddress() + "发来消息");
	    System.out.println("【接收时间】" + getTime());
	    System.out.println("【消息内容】\n" + in.toString(CharsetUtil.UTF_8));
	    
	    // 释放接收到的数据空间
		// ReferenceCountUtil.release(msg);
	}
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx,
        Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }

}
