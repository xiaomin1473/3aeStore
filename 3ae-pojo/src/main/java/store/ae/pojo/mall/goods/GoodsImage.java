package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsImage {
	
	private Long GoodsId;
	
	private Long categoryType;
	
	private String name;
	
	private Integer numberInfo;
	
	private Integer numberDetail;
	
	private String suffixType;
	
	private String urlsInfo;
	
	private String urlsDetail;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;

}
