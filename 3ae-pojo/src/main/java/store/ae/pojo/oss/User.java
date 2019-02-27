package store.ae.pojo.oss;

import java.util.Date;

import lombok.Data;


@Data
public class User {
	private long userId;
	
	private String userName;
	
	private String userPwd;
	
	private String userMark;
	
	private long userGroupId;
	
	private long userPermit;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
