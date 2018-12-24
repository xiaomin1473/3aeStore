package store.ae.pojo.mall.goods;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class GoodsSku {
	private long goodsSkuId;
	
	private long goodsId;
	
	private long categoryType;
	
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
	
	private long number;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
