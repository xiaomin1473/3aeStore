package store.ae.dto.service.oss;

import store.ae.pojo.oss.User;

public class UserExecution {
	/**
	 * 登录状态
	 */
	private int state;
	
	/**
	 * 登录提示
	 */
	private String stateInfo;
	
	/**
	 * 登录成功对象
	 */
	private User user;

	@Override
	public String toString() {
		return "UserExecution [state=" + state + 
				", stateInfo=" + stateInfo + 
				", user=" + user + "]";
	}

	public UserExecution(int state, String stateInfo) {
		super();
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public UserExecution(int state, String stateInfo, User user) {
		super();
		this.state = state;
		this.stateInfo = stateInfo;
		this.user = user;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
