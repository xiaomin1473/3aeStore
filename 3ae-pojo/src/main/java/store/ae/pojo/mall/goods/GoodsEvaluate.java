package store.ae.pojo.mall.goods;

import java.util.Date;

public class GoodsEvaluate {
	
	private long GoodsId;
	
	private long category;
	
	private String name;
	
	private int evaluateRank;
	
	private long userId;
	
	private String content;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;

	public long getGoodsId() {
		return GoodsId;
	}

	public void setGoodsId(long goodsId) {
		GoodsId = goodsId;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEvaluateRank() {
		return evaluateRank;
	}

	public void setEvaluateRank(int evaluateRank) {
		this.evaluateRank = evaluateRank;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "GoodsEvaluate [GoodsId=" + GoodsId + 
				", category=" + category + 
				", name=" + name + 
				", evaluateRank=" + evaluateRank + 
				", userId=" + userId + 
				", content=" + content + 
				", gmtCreate=" + gmtCreate + "]";
	}



}
