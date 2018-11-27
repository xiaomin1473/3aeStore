package store.ae.pojo.mall.goods;

import java.util.Date;

public class GoodsType {
	
	private long GoodsTypeId;
	
	private int grade;
	
	private int parentGrade;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;

	public long getGoodsTypeId() {
		return GoodsTypeId;
	}

	public void setGoodsTypeId(long goodsTypeId) {
		GoodsTypeId = goodsTypeId;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getParentGrade() {
		return parentGrade;
	}

	public void setParentGrade(int parentGrade) {
		this.parentGrade = parentGrade;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "GoodsType [GoodsTypeId=" + GoodsTypeId + 
				", grade=" + grade + 
				", parentGrade=" + parentGrade + 
				", gmtCreate=" + gmtCreate + "]";
	}
}
