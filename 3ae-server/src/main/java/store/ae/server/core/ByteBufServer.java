package store.ae.server.core;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import store.ae.server.common.ConfigUtil;

@Sharable
public class ByteBufServer extends ChannelInboundHandlerAdapter {
	
	
	private String SERVER_INFO = "【服务端】";
	
   /**
    * 客户端与服务端创建连接的时候调用。激活连接，每个连接只会调用一次。
    * 
    */
   @Override
   public void channelActive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.add(ctx.channel());
      
	   System.out.println("【服务管理】 新的客户端建立连接!");
	   System.out.println("【连接状态】" + ctx);
	   ctx.write("sss");
   }

   /**
    * 客户端与服务端断开连接时调用
    */
   @Override
   public void channelInactive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.remove(ctx.channel());
	   
	   System.out.println("【连接状态】" + ctx.channel().remoteAddress().toString() + "\t 关闭");
   }

   /**
    *  任何信息入站都会调用该方法。
    *  服务端处理客户端websocket请求的核心方法，这里接收了客户端发来的信息
    */
   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
	   ByteBuf in = (ByteBuf) msg;
       
	   System.out.println(SERVER_INFO + ctx.channel().remoteAddress().toString() + " 发来消息：\n" + in.toString(CharsetUtil.UTF_8));        //2
       
       ctx.write(in);
   }

   /**
    * 服务端接收客户端发送过来的数据结束之后调用
    */
   @Override
   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

	   ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
	   ctx.flush();
	   //System.out.println(SERVER_INFO + ctx.channel().remoteAddress().toString() + "数据读取已完成");
   }
   
   /**
    * 读操作时捕获到异常时调用，工程出现异常的时候调用
    */
   @Override
   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      cause.printStackTrace();//5
      ctx.close();//6
   }
   
   @Override
   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
       System.out.println("Other  userEventTriggered");
   }
   
   @Override
   public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
       System.out.println("Other  channelWritabilityChanged");
   }
}
