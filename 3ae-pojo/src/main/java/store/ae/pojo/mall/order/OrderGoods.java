package store.ae.pojo.mall.order;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OrderGoods {
	private Long orderId;
	
	private Long goodsSkuId;
	
	private Long categoryType;
	
	private String goodsName;
	
	private Integer goodsNumber;
	
	private String unit;
	
	private BigDecimal skuPrice;
	
	private String imgUrl;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
