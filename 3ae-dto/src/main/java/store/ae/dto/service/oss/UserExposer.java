package store.ae.dto.service.oss;

public class UserExposer {
	private boolean logined;
	
	private String token;
	
	private String userName;
	
	private long nowTime;
	
	public UserExposer(boolean logined, String token, String userName, long nowTime) {
		super();
		this.logined = logined;
		this.token = token;
		this.userName = userName;
		this.nowTime = nowTime;
	}

	public UserExposer(boolean logined, String userName, long nowTime) {
		super();
		this.logined = logined;
		this.userName = userName;
		this.nowTime = nowTime;
	}

	public boolean isLogined() {
		return logined;
	}

	public void setLogined(boolean logined) {
		this.logined = logined;
	}

	public String getTocken() {
		return token;
	}

	public void setTocken(String tocken) {
		this.token = tocken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getNowTime() {
		return nowTime;
	}

	public void setNowTime(long nowTime) {
		this.nowTime = nowTime;
	}
}
