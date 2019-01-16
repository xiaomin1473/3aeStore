package store.ae.server.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 程序的入口，负责启动应用
 * @author sidtadpole
 *
 */
public class Server {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String SERVER_INFO = "\n【服务管理】";
	
	public Server(int serverport){
		bind(serverport);
	}
	public void bind(int port) {
		EventLoopGroup boosGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			
			bootstrap.group(boosGroup, workGroup).channel(NioServerSocketChannel.class)
				//有数据立即发送
				.childOption(ChannelOption.TCP_NODELAY, true)
				//保持连接数
				.option(ChannelOption.SO_BACKLOG, 128)
				//保持连接
				.childOption(ChannelOption.SO_KEEPALIVE, true)
				// 
				.childHandler(new ServerChannel());
			
			Channel ch = bootstrap.bind(port).sync().channel();
			System.out.println(ByteBufServer.class.getName() + " started and listen on " + ch.localAddress());
			
			logger.info("{} 服务端已启动，等待客户端连接……", SERVER_INFO);
			
			
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
