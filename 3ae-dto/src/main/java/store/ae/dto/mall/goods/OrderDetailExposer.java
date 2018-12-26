package store.ae.dto.mall.goods;

import com.google.gson.annotations.SerializedName;

import store.ae.vo.mall.goods.order.OrderDetailVo;

public class OrderDetailExposer {
	
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
	OrderDetailVo OrderDetailVo;

	public OrderDetailExposer(int code, String msg, store.ae.vo.mall.goods.order.OrderDetailVo orderDetailVo) {
		super();
		this.code = code;
		this.msg = msg;
		OrderDetailVo = orderDetailVo;
	}

	public OrderDetailExposer(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
