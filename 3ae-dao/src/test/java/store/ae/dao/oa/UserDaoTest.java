package store.ae.dao.oa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.oa.User;




@RunWith(SpringJUnit4ClassRunner.class)

//告诉junit spring配置文件
@ContextConfiguration({"classpath:store/ae/dao/oa/config/oa-dao.xml"})
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;

	@Test
	public void test() {
		Long userId = 1001L;
		User user = userDao.queryUserById(userId);
		
		System.out.println("sss:" + user);
	}
	
	@Test
	public void testQueryByUserName() {
		User user = userDao.queryByUserName("caiwu");
		
		System.out.println("sss:" + user.getUserPermit());
	}
	
	@Test
	public void testQueryAllUser() {
		List<User> users = userDao.queryAllUser();
		
		System.out.println("sss:" + users);
	}

}
