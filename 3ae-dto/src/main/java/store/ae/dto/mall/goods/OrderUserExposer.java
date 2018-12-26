package store.ae.dto.mall.goods;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import store.ae.vo.mall.goods.order.OrderUserVo;

@Data
public class OrderUserExposer {
	
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
	List<OrderUserVo> OrderUserVoList;

	public OrderUserExposer(int code, String msg, List<OrderUserVo> orderUserVoList) {
		super();
		this.code = code;
		this.msg = msg;
		OrderUserVoList = orderUserVoList;
	}

	public OrderUserExposer(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
