package store.ae.pojo.mall.goods;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsEvaluate {
	
	private long GoodsId;
	
	private long categoryType;
	
	private String evaluateName;
	
	private int evaluateRank;
	
	private long userId;
	
	private String content;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;
	
	private Date gmtModified;
}
