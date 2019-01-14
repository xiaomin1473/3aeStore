package store.ae.agent;

import java.util.List;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MsgDdr extends ByteToMessageDecoder {
 
   
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buff, List<Object> out) throws Exception {
        //标记开始读取位置
    	buff.markReaderIndex();
        //判断协议类型
        byte infoType = buff.readByte();
        Answer requestInfo = new Answer();
        System.out.println(infoType);
        requestInfo.setType(infoType);
        //in.readableBytes()即为剩下的字节数
        byte[] info = new byte[buff.readableBytes()];
        buff.readBytes(info);
        requestInfo.setInfo(new String(info, "utf-8"));
        System.out.println(info.length + " : " + requestInfo.getInfo());
        //最后把你想要交由ServerHandler的数据添加进去，就可以了
        out.add(requestInfo);
    }

}
