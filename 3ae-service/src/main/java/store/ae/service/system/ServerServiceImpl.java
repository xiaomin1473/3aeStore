package store.ae.service.system;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import store.ae.server.core.Server;

@Service
public class ServerServiceImpl implements ServerService {
	
	
	@Override
	@PostConstruct
	public void start() {
		//这里是线程需要做的事情
		new Thread(){
			public void run(){
				System.out.println("【服务线程】 \n");
				new Server(47332);
			}
		}.start();
	}
}
