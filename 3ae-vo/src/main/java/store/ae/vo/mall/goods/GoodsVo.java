package store.ae.vo.mall.goods;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class GoodsVo {
	private long goodsId;
	
	private long brandId;
	
	private long businessId;
	
	private long categoryType;
	
	private String goodsName;
		
	private long amount;
	
	private String unit;
	
	private BigDecimal price;
	
	/**
	 * 	成交量
	 */
	private long volume;
	
	private String imgUrl;
}
