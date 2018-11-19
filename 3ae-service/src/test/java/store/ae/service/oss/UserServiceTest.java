package store.ae.service.oss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.dto.service.oss.UserExecution;
import store.ae.pojo.oss.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/oss/config/oss-dao.xml",
	"classpath:store/ae/service/oss/config/oss-service.xml"})
public class UserServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@Test
	public void testChangePwd() {
		String userName = "root";
		String userPwd = "admin";
		String nowPwd = userService.changePwd(userName, userPwd);
		
		logger.info("nowPwd=" + nowPwd);
	}

	@Test
	public void testCheckUserInfo() {
		String userName = "root";
		String userPwd = "admin";
		UserExecution userExecution = userService.checkUserInfo(userName, userPwd);
		String userInfo = userExecution.getStateInfo();
		User user = userExecution.getUser();
		
		logger.info("userInfo is:" + userInfo);
		logger.info("user is:" + user);
	}

}
