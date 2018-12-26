package store.ae.dto.mall.goods;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import store.ae.vo.mall.goods.GoodsDetailVo;

@Data
public class GoodsDetailExposer {
	
	
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
	GoodsDetailVo goodsDetailVo;

	public GoodsDetailExposer(int code, String msg, GoodsDetailVo goodsDetailVo) {
		super();
		this.code = code;
		this.msg = msg;
		this.goodsDetailVo = goodsDetailVo;
	}

	public GoodsDetailExposer(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
