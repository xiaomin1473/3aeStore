package store.ae.service.oss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.dao.oss.UserDao;
import store.ae.dto.oss.UserExposer;
import store.ae.pojo.oss.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/oss/config/oss-dao.xml",
	"classpath:store/ae/service/oss/config/oss-service.xml"})
public class UserServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
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
		userService.checkUserInfo(userName, userPwd);
		User user = userDao.queryByUserName(userName);
		
		logger.info("userInfo is:" + user.toString());
		logger.info("user is:" + user);
	}
	
	@Test
	public void testExportUserToken() {
		String userName = "root";
		UserExposer exposer = userService.exportUserToken(userName);
		
		logger.info("userTocken is:" + exposer.getTocken());
	}

}
