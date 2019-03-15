package store.ae.service.oa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import store.ae.dao.oa.UserDao;
import store.ae.dto.oa.UserExposer;
import store.ae.pojo.oa.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	// md5盐值字符串，用来混淆md5
	private final String slat = "w6_Aa^p1%@HW+_ijfo&-i14#Yg_T5*%er#HLwr*aMa^F#48_5GA(mf15a^sfaFO*Htg1a_G$PI";
	
	// md5盐值字符串，用来混淆md5
	private final String tokenSlat = "w6_Aa^p1%@f15a^sfaFO*Htg1a_G$PI";
	
	private String getMD5(String userPwd) {
		String base = userPwd +"." + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		
		return md5;
	}
	
	private String getToken(String userName) {
		String base = userName +"^" + tokenSlat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		
		return md5;
	}
	
	public User getUser(Long Id) {
		
		return userDao.queryUserById(Id);
	}
	
	@Override
	public User queryUserByUserName(String userName) {
		User user = userDao.queryByUserName(userName);
		
		return user;
	}
	
	@Override
	public boolean checkUserInfo(String userName, String userPwd) {
		User user = userDao.queryByUserName(userName);
		if(user != null) {
			String pwdMD5 = getMD5(userPwd);
			if(user.getUserPwd().equals(pwdMD5)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public UserExposer exportUserToken(String userName) {
		UserExposer exposer;
		
		Date nowTime = new Date();
		try {
			User user = userDao.queryByUserName(userName);
			
			if(user == null) {
				return new UserExposer(false, userName, nowTime.getTime());
			}
			
			String token = getToken(userName);
			
			exposer = new UserExposer(true, token, userName, user.getUserPermit(), nowTime.getTime());

		} catch (Exception e) {
			return new UserExposer(false, userName, nowTime.getTime());
		}
		
		return exposer;
	}

	@Override
	public List<User> getAllUser() {
		
		 List<User> users = userDao.queryAllUser();
		
		return users;
	}
}
