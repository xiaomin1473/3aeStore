package store.ae.server.core;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class BufferOutServer extends ChannelOutboundHandlerAdapter {
	
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("EchoServerOutHandler   write "+((ByteBuf)msg).toString(Charset.defaultCharset()));
        ctx.write(msg, promise);
    }
}
