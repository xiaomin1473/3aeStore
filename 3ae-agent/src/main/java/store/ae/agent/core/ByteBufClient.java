package store.ae.agent.core;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@Sharable
public class ByteBufClient extends SimpleChannelInboundHandler<ByteBuf> {
	
	private String CLIENT_INFO = "【客户端】";
	
	@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("【连接信息】 " + ctx);
		
		ctx.writeAndFlush(Unpooled.copiedBuffer(ctx.channel().remoteAddress().toString() + "接入成功!",
		        CharsetUtil.UTF_8));
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		
		System.out.println(CLIENT_INFO + "服务端发来消息： \n" + msg.toString(CharsetUtil.UTF_8));

	}
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx,
        Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }

}
