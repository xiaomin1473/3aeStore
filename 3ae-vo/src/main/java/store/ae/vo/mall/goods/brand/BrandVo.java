package store.ae.vo.mall.goods.brand;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class BrandVo {
	
	@SerializedName("num")
	private long brandId;
	
	@SerializedName("name")
	private String brandName;
	
	@SerializedName("tips")
	private String brandTips;
	
	@SerializedName("image_url")
	private String imgUrl;
}
