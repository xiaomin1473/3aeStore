package store.ae.dao.oss;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import store.ae.pojo.oss.User;

public interface UserDao {
	
	/**
	 * @return
	 */
	User queryByUserName(@Param("userName") String userName);
	
	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	void changePwd(@Param("userName")String userName, @Param("userPwd") String userPwd);
}
