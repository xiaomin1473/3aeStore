package store.ae.pojo.oa;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	
	private long userId;
	
	private long userGroupId;
	
	private long userPowerId;
	
	private String userName;
	
	private String userPwd;
	
	private String userMark;
	
	private long departmentType;
	
	private long userPermit;
	
	private int loginStatus;
	
	private Date gmtCreate;
	
	private Date gmtModified; 
}
