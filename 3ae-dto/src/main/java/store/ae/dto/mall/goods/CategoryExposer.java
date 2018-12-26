package store.ae.dto.mall.goods;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import store.ae.vo.mall.goods.category.CategoryVo;


@Data
public class CategoryExposer {
	
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
	List<CategoryVo> categoryVoList;

	public CategoryExposer(int code, String msg, List<CategoryVo> categoryVoList) {
		super();
		this.code = code;
		this.msg = msg;
		this.categoryVoList = categoryVoList;
	}

	public CategoryExposer(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	
}
