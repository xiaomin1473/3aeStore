package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;

@Data
public class Category {
	
	private long categoryId;
	
	private String categoryName;
	
	private String categoryType;
	
	private String gradeType;
	
	private String seriesType;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
