package store.ae.dao.oa;

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
		Long Id = 1L;
		User user = userDao.queryUserById(Id);
		
		System.out.println("sss:" + user);
	}

}
