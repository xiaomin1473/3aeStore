package com.ae.couplet.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author sidtadpole
 *	编码器
 */
public class serverMsgEdr extends MessageToByteEncoder<serverInfo> {

	@Override
	protected void encode(ChannelHandlerContext ctx, serverInfo msg, ByteBuf out) throws Exception {
		@SuppressWarnings("resource")
		ByteBufOutputStream writer = new ByteBufOutputStream(out);
        
        writer.writeByte(msg.getType());
        byte[] info = null;
 
        if (msg != null &&msg.getInfo() != null && msg.getInfo() != "") {
        	info = msg.getInfo().getBytes("utf-8");
        	writer.write(info);
        }
		
	}

}
