package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsEvaluate {
	
	private Long GoodsId;
	
	private Long categoryType;
	
	private String evaluateName;
	
	private Integer evaluateRank;
	
	private Long userId;
	
	private String content;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
