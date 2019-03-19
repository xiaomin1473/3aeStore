package store.ae.service.oa;

import java.util.List;
import java.util.Map;

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
	 * 
	 * 根据用户名查询用户
	 */
	User queryUserByUserName(String userName);
	
	/**
	 * @return
	 * 获取所有用户
	 */
	List<User> getAllUser();
	
	/**
	 * @param params
	 * @return
	 * 添加用户
	 */
	boolean addUser(Map<String, Object> params);
	
	/**
	 * @param userName
	 * @param user
	 * @return
	 * 
	 * 修改用户
	 */
	boolean updateUser(String userName, User user);
	
	
	/**
	 * @param userName
	 * @return
	 * 
	 * 删除用户
	 */
	boolean delUser(String userName);
	
	/**
	 * @param userName
	 * @param userPwd
	 * @return
	 * 
	 * 验证用户
	 */
	boolean checkUserInfo(String userName, String userPwd);
	
	/**
	 * @param userName
	 * @return
	 */
	UserExposer exportUserToken(String userName);
}
