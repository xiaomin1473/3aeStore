package store.ae.dto.mall.goods;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import store.ae.vo.mall.goods.order.OrderUserVo;

@Data
public class UserOrderExposer {
	
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
	OrderUserVo OrderUserVo;
}
