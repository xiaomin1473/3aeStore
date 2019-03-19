package store.ae.dao.oa;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.oa.User;



public interface UserDao {
	
	/**
	 * @param id
	 * @return
	 * 通过id查询用户信息
	 * 
	 */
	User queryUserById(@Param("userId") long userId);
	
	
	/**
	 * @return
	 * 返回所有用户
	 */
	List<User> queryAllUser();
	
	
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	boolean insertUser(@Param("user") User user);
	
	/**
	 * @param userName
	 * @param user
	 * @return
	 * 
	 * 更新用户
	 */
	boolean updateUser(@Param("userName") String userName, @Param("user") User user);
	
	/**
	 * @param userName
	 * @return
	 * 
	 * 删除用户
	 */
	boolean delUser(String userName);
	
	/**
	 * @param userName
	 * @return
	 */
	User queryByUserName(@Param("userName") String userName);
}
