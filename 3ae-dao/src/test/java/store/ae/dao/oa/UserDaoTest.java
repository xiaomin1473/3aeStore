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
	
	@Test
	public void testAddUser() {
		User user = new User();

		long userGroupId = 1003;
		long userPowerId = 1003;
		String userMark= "";
		String userName = "test";
		String userPwd ="pwd";
		long departmentType = 1030000;
		long userPermit = 10003;
		int loginStatus = 0;
		
		user.setUserGroupId(userGroupId);
		user.setUserPowerId(userPowerId);
		user.setUserMark(userMark);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setDepartmentType(departmentType);
		user.setUserPermit(userPermit);
		user.setLoginStatus(loginStatus );
		
		boolean a = userDao.insertUser(user);
		System.out.println(a);
	}
	
	
	@Test
	public void testUpdateUser() {
		User user = new User();

		long userGroupId = 1003;
		long userPowerId = 1004;
		String userMark= "";
		String userName = "test";
		String userPwd ="pwd";
		long departmentType = 1030000;
		long userPermit = 10003;
		int loginStatus = 0;
		
		user.setUserGroupId(userGroupId);
		user.setUserPowerId(userPowerId);
		user.setUserMark(userMark);
		user.setUserName(userName);
		user.setUserPwd(userPwd);
		user.setDepartmentType(departmentType);
		user.setUserPermit(userPermit);
		user.setLoginStatus(loginStatus );
		
		boolean a = userDao.updateUser(userName, user);
		System.out.println(a);
	}
	
	@Test
	public void testdelUser() {
		boolean a = userDao.delUser("test");
		System.out.println(a);
	}

}
