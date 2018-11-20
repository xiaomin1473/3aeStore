package store.ae.service.oss;

import store.ae.dto.service.oss.UserExposer;
import store.ae.exception.oss.UserErrorException;
import store.ae.exception.oss.UserException;
import store.ae.exception.oss.UserNullException;
import store.ae.pojo.oss.User;

public interface UserService {
	
	/*
	 *  1. 是否存在user，不存在=>注册
	 *  2. 验证用户信息
	 *  3. 返回加密用户信息存入cookie
	 *  
	 */
	
	User queryUserByUserName(String userName);
	
	/**
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	String changePwd(String userName, String userPwd);
	
	/**
	 * @param userName
	 * @return
	 */
	UserExposer exportUserToken(String userName);
	
	
	/**
	 * @param userName
	 * @param userPwd
	 * @return
	 * @throws UserErrorException
	 * @throws UserNullException
	 * @throws UserException
	 */
	boolean checkUserInfo(String userName, String userPwd)
			throws UserErrorException, UserNullException, UserException;
}
