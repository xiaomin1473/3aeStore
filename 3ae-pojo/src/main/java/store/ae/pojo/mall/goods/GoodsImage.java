package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsImage {
	
	private long GoodsId;
	
	private long categoryType;
	
	private String name;
	
	private int numberInfo;
	
	private int numberDetail;
	
	private String suffixType;
	
	private String urlsInfo;
	
	private String urlsDetail;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;

}
