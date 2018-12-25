package store.ae.pojo.blog.user;

import lombok.Data;

@Data
public class User {
	private long userId;
	
	private String userName;
	
	private String userPwd;
	
	private Integer userGroupId;

	private Integer userInfoId;

}
