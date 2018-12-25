package store.ae.pojo.mall.order;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OrderGoods {
	private long orderId;
	
	private long goodsSkuId;
	
	private long categoryType;
	
	private String goodsName;
	
	private int goodsNumber;
	
	private String unit;
	
	private BigDecimal skuPrice;
	
	private String imgUrl;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
