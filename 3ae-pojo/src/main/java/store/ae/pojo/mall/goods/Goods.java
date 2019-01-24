package store.ae.pojo.mall.goods;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Goods {

	private Long goodsId;
	
	private Long brandId;
	
	private Long businessId;
	
	private Long categoryType;
	
	private String goodsName;
		
	private Long amount;
	
	private String unit;
	
	private BigDecimal price;
	
	private Long volume;
	
	private String imgUrl;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
