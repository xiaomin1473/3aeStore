package store.ae.server.core;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import store.ae.server.common.ConfigUtil;

public class BufferInServer extends ChannelInboundHandlerAdapter {
	
   /**
    * 客户端与服务端创建连接的时候调用。激活连接，每个连接只会调用一次。
    */
   @Override
   public void channelActive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.add(ctx.channel());
      
	   System.out.println("【服务状态】 新的客户端建立连接!");
	   System.out.println("【连接信息】" + ctx);
   }

   /**
    * 客户端与服务端断开连接时调用
    */
   @Override
   public void channelInactive(ChannelHandlerContext ctx) throws Exception {
	   ConfigUtil.group.remove(ctx.channel());
	   
	   System.out.println("【服务状态】 客户端连接关闭!");
   }
 
   /**
    * 读操作时捕获到异常时调用，工程出现异常的时候调用
    */
   @Override
   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      cause.printStackTrace();
      ctx.close();
   }

   /**
    *  任何信息入站都会调用该方法。
    *  服务端处理客户端websocket请求的核心方法，这里接收了客户端发来的信息
    */
   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

	   	System.out.println("【服务状态】客户端信息" + msg);
   }

   /**
    * 服务端接收客户端发送过来的数据结束之后调用
    */
   @Override
   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
	   System.out.println("【服务状态】客户端信息读完了!");
	   ctx.flush();
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
