package store.ae.service.oss.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import store.ae.dao.oss.UserDao;
import store.ae.dto.service.oss.UserExposer;
import store.ae.pojo.oss.User;
import store.ae.service.oss.UserService;

@Service
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserDao userDao;
	
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
	public String changePwd(String userName, String userPwd) {
		String pwdMD5 = getMD5(userPwd);
		String oldPwd = userDao.queryByUserName(userName).getUserPwd();
		userDao.changePwd(userName, pwdMD5);
		String nowPwd = userDao.queryByUserName(userName).getUserPwd();
		logger.info("password form" + oldPwd +"to" + nowPwd);
		return nowPwd;
	}


	@Override
	public UserExposer exportUserToken(String userName) {
		UserExposer exposer;
		
		Date nowTime = new Date();
		try {
			User user = userDao.queryByUserName(userName);
			
			if(user == null) {
				exposer = new UserExposer(false, userName, nowTime.getTime());
				return exposer;
			}
			
			String token = getToken(userName);
			exposer = new UserExposer(true, token, userName, nowTime.getTime());

		} catch (Exception e) {
			exposer = new UserExposer(false, userName, nowTime.getTime());
		}
		
		return exposer;
	}
	
}