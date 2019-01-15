package store.ae.agent.core;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class BufferClient extends SimpleChannelInboundHandler<Object> {
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		System.out.println("【连接信息】 " + ctx);
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		System.out.println("clinet");
		ctx.writeAndFlush(Unpooled.copiedBuffer("777".getBytes()));
	}
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx,
        Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }

}
