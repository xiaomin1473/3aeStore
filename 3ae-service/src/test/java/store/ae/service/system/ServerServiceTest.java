package store.ae.service.system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.service.system.ServerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/oss/config/oss-dao.xml",
	"classpath:store/ae/service/system/config/system-service.xml"})
public class ServerServiceTest {
	
	@Autowired
	private ServerService serverService;
	
	@Test
	public void testStart() {
		serverService.start();
	}
}
