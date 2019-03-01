package store.ae.service.oa;

import store.ae.dto.oa.UserExposer;
import store.ae.pojo.oa.User;

public interface UserService {
	
	/**
	 * 获取用户ID
	 * @param Id
	 * @return
	 */
	User getUser(Long Id);
	
	/**
	 * @param userName
	 * @return
	 */
	User queryUserByUserName(String userName);
	
	/**
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	boolean checkUserInfo(String userName, String userPwd);
	
	/**
	 * @param userName
	 * @return
	 */
	UserExposer exportUserToken(String userName);
}
