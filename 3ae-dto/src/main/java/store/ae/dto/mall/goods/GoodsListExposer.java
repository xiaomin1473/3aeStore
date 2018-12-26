package store.ae.dto.mall.goods;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import store.ae.vo.mall.goods.GoodsVo;

public class GoodsListExposer {
	
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
	List<GoodsVo> goodsVoList;

	public GoodsListExposer(int code, String msg, List<GoodsVo> goodsVoList) {
		super();
		this.code = code;
		this.msg = msg;
		this.goodsVoList = goodsVoList;
	}

	public GoodsListExposer(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
