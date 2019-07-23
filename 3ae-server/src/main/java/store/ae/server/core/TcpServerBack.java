package store.ae.server.core;

import java.text.SimpleDateFormat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import store.ae.server.common.ConfigUtil;

@Sharable
public class TcpServerBack extends ChannelInboundHandlerAdapter {

   /**
    * 
    * 客户端与服务端创建连接的时候调用。激活连接，每个连接只会调用一次。
    * 
    */
   @Override
   public void channelActive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.add(ctx.channel());
	   
	   System.out.println("\n【连接状态】" + ctx);
	   System.out.println("【建立时间】" + getTime());
	   System.out.println("【服务管理】已与客户端 " + ctx.channel().remoteAddress() + " 建立连接!");

   }

   /**
    * 客户端与服务端断开连接时调用
    */
   @Override
   public void channelInactive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.remove(ctx.channel());
	   
	   System.out.println("\n【连接状态】" + ctx.channel().remoteAddress() + "\t 已关闭");
   }

   /**
    *  任何信息入站都会调用该方法。
    *  服务端处理客户端websocket请求的核心方法，这里接收了客户端发来的信息
    */
   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	   ByteBuf in = (ByteBuf) msg;
	   Integer len = in.readableBytes();
	   byte[] bytes = null;
	   
	   // 直接缓存区
	   if (!in.hasArray()) { 
		   // 字节数组转字符
		   bytes = new byte[len];
		   in.getBytes(in.readerIndex(), bytes);
	   }
	   
	   // 数组缓存区
	   if (in.hasArray()) { 
		   System.out.println("Is a array");
	   }
	   
//	   if(!check(bytes, len)) {
//		   ctx.writeAndFlush(Unpooled.copiedBuffer("数据发生错误，请重新发送!",
//			        CharsetUtil.UTF_8));
//		   
//		   System.out.println("\n【新短消息】" + ctx.channel().remoteAddress() + "发来消息");
//		   System.out.println("【接收时间】" + getTime());
//		   System.out.println("【服务管理】" + "校验失败");
//		   return;
//	   }
	   
	   
	   String buf = byteToString(bytes);
	   
	   // 格式化输出报文头
	   // UTF-8
	   String context = format2UTF8(in, len, buf);
	   
	   String devInfo = getInfo(buf);
	   
       
	   // 命令行输出
	   System.out.println("\n【新短消息】" + ctx.channel().remoteAddress() + "发来消息");
	   System.out.println("【接收时间】" + getTime());
	   System.out.println("【消息内容】\n" + context);
	   System.out.println("【设备信息】\n" + devInfo);
	   
	   ReferenceCountUtil.release(msg);
   }

   /**
    * 服务端接收客户端发送过来的数据结束之后调用
    */
   @Override
   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	   //ctx.write(Unpooled.copiedBuffer("服务器主动关闭连接!", CharsetUtil.UTF_8));
	   ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
	   ctx.flush();
	   //ctx.close();
	   //System.out.println(SERVER_INFO + ctx.channel().remoteAddress().toString() + "数据读取已完成");
   }
   
   /**
    * 读操作时捕获到异常时调用，工程出现异常的时候调用
    */
   @Override
   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      cause.printStackTrace();
      ctx.close();
   }
   
   @Override
   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
       // System.out.println("Other  userEventTriggered");
   }
   
   @Override
   public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
       // System.out.println("Other  channelWritabilityChanged");
   }
   
   
   private String getInfo(String buf) {
	   // 字符转数组
	   String[] orign = buf.split(" ");
	   
	   
	   String str = "序列号:"+ orign[15] + orign[14] + "\n日期：" +
			   (short)(Integer.valueOf(orign[16], 16) & 0xffff) + "-" + 
			   (short)(Integer.valueOf(orign[17], 16) & 0xffff) + "-" +
			   (short)(Integer.valueOf(orign[18], 16) & 0xffff) +
			   "\n流水号：" + orign[20] + orign[19] +
			   "\n\n版本号：" + (short)(Integer.valueOf(orign[21], 16) & 0xffff) + "." +
			   (short)(Integer.valueOf(orign[22], 16) & 0xffff) + "build" +
			   "  日期：" + (short)(Integer.valueOf(orign[23], 16) & 0xffff) + "-" + 
			   (short)(Integer.valueOf(orign[24], 16) & 0xffff) + "-" +
			   (short)(Integer.valueOf(orign[25], 16) & 0xffff);
	   
	   return str;
   }
   
   
   
   
   

   /**
    * 转格式成utf-8
    * 
	* @param in
	* @param len
	* @param buf
	* @return
	*/
   private String format2UTF8(ByteBuf in, Integer len, String buf) {   
	   String context = 
		   msgr(
	   			msgr(
	   				msgr(" lenght: ", len.toString()),
	   				msgr("\n context: ", in.toString(CharsetUtil.UTF_8))
	   				//msgr("\n context: ", in.toString())
				),
			   msgr("\n\n【明文编码】 ", buf)
		   );
	   return context;
   }
   
	
	/**
	 * 
	 * 获取服务器时间
	 * 
	 * @return
	 */
	private String getTime() {
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return time.format(System.currentTimeMillis());
	}
	
	/**	
	 * 
	 * 字节数组转字符串
	 * 
	 * @param bytes
	 * @return
	 */
	private String byteToString(byte[] bytes) {
		StringBuffer buf = new StringBuffer();
		   for (byte b : bytes) {
				int d = b & 0xFF;
				String v = Integer.toHexString(d).toUpperCase();
				if (v.length() == 1) {
					v = "0" + v;
				}
				buf.append(v + " ");
			}
		return buf.toString();
	}
	
	/**
	 * 字符串拼接，代替+
	 * @param a
	 * @param b
	 * @return
	 */
	private String msgr(String a, String b) {
		
		StringBuffer contentBuffer = new StringBuffer();
		
		contentBuffer.append(a);
		contentBuffer.append(b);
		
		return contentBuffer.toString();
	}
	
	@SuppressWarnings("unused")
	private Boolean check(byte[] bytes, int len) {
		int sum = 0;
		   
		for (int i = 0; i < len-3; i++) {
			sum = bytes[i] & 0xff;
		   
		    sum += sum;
	    }
	   
	    sum = sum & 0xff;
	    
	    if(sum != bytes[len-3]) {
		    return false;
	    }
	    
	    return true;
	}
}
