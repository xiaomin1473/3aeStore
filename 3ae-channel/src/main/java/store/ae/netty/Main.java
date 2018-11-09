package store.ae.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 程序入口，负责启动应用
 * @author sidtadpole
 *
 */
public class Main {
	public static void main(String[] args) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new WebSocketChannelHandler());
			System.out.println("服务器开启，等待客户端连接……");
			
			Channel ch = b.bind(8080).sync().channel();
			ch.closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
