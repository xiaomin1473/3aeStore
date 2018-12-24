package store.ae.pojo.mall.goods;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Goods {
	private long goodsId;
	
	private long brandId;
	
	private long businessId;
	
	private long categoryType;
	
	private String goodsName;
		
	private long amount;
	
	private String unit;
	
	private BigDecimal price;
	
	private long volume;
	
	private String imgUrl;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
