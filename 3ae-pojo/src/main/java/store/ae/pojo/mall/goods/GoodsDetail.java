package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsDetail {
	
	private long GoodsId;
	
	private String categoryType;
	
	private String goodsName;
	
	private String detail;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
