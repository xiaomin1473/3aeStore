package store.ae.dto.mall.goods;

import com.google.gson.annotations.SerializedName;

public class UniteExposer<T> {
	
	/**
	 * 是否开启该api
	 */
	@SerializedName("code")
	private int code;
	
	/**
	 * 是否开启该api
	 */
	@SerializedName("msg")
	private String msg;
	
	/**
	 * 返回api
	 */
	@SerializedName("data")
	private T data;

	public UniteExposer(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public UniteExposer(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
