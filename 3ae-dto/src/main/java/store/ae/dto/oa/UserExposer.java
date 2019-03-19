package store.ae.dto.oa;

import lombok.Data;

@Data
public class UserExposer {
	private boolean logined;
	
	private String token;
	
	private String userName;
	
	private long userPermit;
	
	private long departmentType;
	
	private long nowTime;
	
	public UserExposer(boolean logined, String token, String userName, long userPermit, long departmentType, long nowTime) {
		super();
		this.logined = logined;
		this.token = token;
		this.userName = userName;
		this.userPermit = userPermit;
		this.departmentType = departmentType;
		this.nowTime = nowTime;
	}

	public UserExposer(boolean logined, String userName, long nowTime) {
		super();
		this.logined = logined;
		this.userName = userName;
		this.nowTime = nowTime;
	}
}
