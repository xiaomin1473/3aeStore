package store.ae.server.core;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

public class MyOutboundHandler extends ChannelHandlerAdapter {
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
    	System.out.println("close.....");
    }
}
