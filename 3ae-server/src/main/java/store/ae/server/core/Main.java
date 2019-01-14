package store.ae.server.core;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 程序的入口，负责启动应用
 * @author sidtadpole
 *
 */
public class Main {
	public static void main(String[] args) {
		EventLoopGroup boosGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			
			bootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class);
			bootstrap.childHandler(new ChannelInit());
			System.out.println("服务端开启等待客户端连接……");
			
			Channel ch = bootstrap.bind(8888).sync().channel();
			
			ch.closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 优雅的退出程序
			boosGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
