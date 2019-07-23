package store.ae.server.dto;

public class Response {

	/**
	 * 错误码.
	 */
	private int code;

	/**
	 * 回复的信息对象.
	 */
	private Object resObj = null;

	/**
	 * 获取错误码.
	 * 
	 * @return 错误码
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 设置错误码.
	 * 
	 * @param code
	 *            错误码
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 获取回复的信息对象.
	 * 
	 * @return 回复的信息对象
	 */
	public Object getResObj() {
		return resObj;
	}

	/**
	 * 设置回复的信息对象.
	 * 
	 * @param resObj
	 *            回复的信息对象
	 */
	public void setResObj(Object resObj) {
		this.resObj = resObj;
	}
}