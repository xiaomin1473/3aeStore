package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;

@Data
public class Category {
	
	private Long categoryId;
	
	private String categoryName;
	
	private Long categoryType;
	
	private Long gradeType; 
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
