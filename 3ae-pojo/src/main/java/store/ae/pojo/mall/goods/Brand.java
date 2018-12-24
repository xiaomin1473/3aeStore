package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;


@Data
public class Brand {
	private long brandId;
	
	private String brandName;
	
	private String brandTips;
	
	private String imgUrl;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
