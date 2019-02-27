package store.ae.dao.oa;

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
	 * @param userName
	 * @return
	 */
	User queryByUserName(@Param("userName") String userName);
}
