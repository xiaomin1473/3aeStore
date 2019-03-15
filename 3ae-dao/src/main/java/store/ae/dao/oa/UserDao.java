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
	 * @param userName
	 * @return
	 */
	User queryByUserName(@Param("userName") String userName);
}
