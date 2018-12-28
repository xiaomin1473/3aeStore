package store.ae.dto.mall.goods;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;


@Data
public class ListExposer<T> {
	
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
	List<T> list;


	public ListExposer(int code, String msg, List<T> list) {
		this.code = code;
		this.msg = msg;
		this.list = (List<T>) list;
	}

	public ListExposer(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
