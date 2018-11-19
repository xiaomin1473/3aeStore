package store.ae.pojo.oss;

import java.util.Date;

public class User {
	private long userId;
	
	private String userName;
	
	private String userPwd;
	
	private String userMark;
	
	private long userGroupId;
	
	private Date gmtCreate;
	
	private Date gmtModified;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserMark() {
		return userMark;
	}

	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}

	public long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + 
				", userName=" + userName + 
				", userPwd=" + userPwd + 
				", userMark=" + userMark + 
				", userGroupId=" + userGroupId + 
				", gmtCreate=" + gmtCreate + 
				", gmtModified=" + gmtModified + "]";
	}
	
	
}
