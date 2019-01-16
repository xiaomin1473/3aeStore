package store.ae.service.system;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class SystemService implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【系统管理】服务器正常启动……");
	}
}
