package store.ae.vo.mall.goods;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class GoodsVo {
	private Long goodsId;
	
	private Long brandId;
	
	private Long businessId;
	
	private Long categoryType;
	
	private String goodsName;
		
	private Long amount;
	
	private String unit;
	
	private BigDecimal price;
	
	/**
	 * 	成交量
	 */
	private Long volume;
	
	private String imgUrl;
}
