package store.ae.pojo.mall.goods;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class GoodsSku {
	private Long goodsSkuId;
	
	private Long goodsId;
	
	private Long categoryType;
	
	private String name;
	
	private String color;
	
	private String model;
	
	private String format;
	
	private String param;
	
	private String props;
	
	private String weight;
	
	private String imgUrl;
	
	private BigDecimal market;
	
	private BigDecimal mall;
	
	private Long number;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
