package store.ae.agent.core;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * 初始化连接时候的各个组件
 * @author sidtadpole
 *
 */
public class ClientChannel extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel e) throws Exception {
		
		// e.pipeline().addLast("http-codec", new HttpServerCodec());
		
		// e.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
		
		// e.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
		
		e.pipeline().addLast("handler", new TcpClient());
	}

}
