package store.ae.agent.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String CLIENT_INFO = "\n【客户管理】";
	
	public Client(String host, int port){
		bind(host, port);
	}
	public void bind(String host, int port) {
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			Bootstrap bootstrap = new Bootstrap();
			
			bootstrap.group(group).channel(NioSocketChannel.class)
				.handler(new ClientChannel());
			
			ChannelFuture ch = bootstrap.connect(host, port).sync();

			System.out.println(Client.class.getName() + " started and listen on " + ch.channel().localAddress());
			logger.info("{} 客户端已启动，等待接收……", CLIENT_INFO);
			
			ch.channel().closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 优雅的退出程序
			group.shutdownGracefully();
		}
	}
}
