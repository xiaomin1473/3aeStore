package store.ae.dao.oss;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.oss.User;

@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/oss/config/oss-dao.xml"})
public class UserDaoTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	UserDao userDao;
	
	@Test
	public void testGetUserByUserName() {
		User user = userDao.queryByUserName("root");
		logger.info(user.toString());
	}

	@Test
	public void testQueryAll() {
		List<User> users = userDao.queryAll(0, 100);
		logger.info(users.toString());
		for(User user: users) {
			logger.info("user={}", user);
		}
	}
	
	@Test
	public void testChangePwd() {
		String userName = "root";
		String userPwd = "sfadsf222";
		
		userDao.changePwd(userName, userPwd);
		User user = userDao.queryByUserName("root");
		
		logger.info("user password is : " + user.getUserPwd());
		
	}
}
