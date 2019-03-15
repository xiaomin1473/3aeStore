package store.ae.service.oa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import store.ae.pojo.oa.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:store/ae/dao/oa/config/oa-dao.xml",
	"classpath:store/ae/service/oa/config/oa-service.xml"})
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void testGetUser() {
		Long Id = 1L;
		
		User user = userService.getUser(Id);
		System.out.println(user);
		
	}
	
	@Test
	public void testQueryUserByUserName() {
		String userName = "root";
		
		User user = userService.queryUserByUserName(userName);
		
		System.out.println(user);
	}
	
	
	@Test
	public void testGetAllUser() {
		
		List<User> users = userService.getAllUser();
		
		System.out.println(users);
	}
}
