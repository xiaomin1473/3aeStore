package store.ae.common.enums.oss;

public enum UserStatEnum  {
	SUCCESS(1, "登录成功"),
	END(0, "用户名密码错误"),
	REPEAT_KILL(-1, "重复登录"),
	INNER_ERROR(-2, "系统异常"),
	DATA_REWRITE(-3, "用户信息篡改");
	
	private String stateInfo;

	private int state;
	
	private UserStatEnum(int state, String staeInfo) {
		this.state = state;
		this.stateInfo = staeInfo;
	}
	
	public String getStateInfo() {
		return stateInfo;
	}


	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public static UserStatEnum stateof(int index) {
		for(UserStatEnum state : values()) {
			if(state.getState() == index) {
				return state;
			}
		}
		
		return null;
	}
}
