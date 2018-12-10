package store.ae.pojo.mall.goods;

import java.util.Date;

public class GoodsDetail {
	
	private long GoodsId;
	
	private String classType;
	
	private String name;
	
	private String detail;
	
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

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "GoodsDetail [GoodsId=" + GoodsId + 
				", classType=" + classType + 
				", name=" + name + 
				", detail=" + detail + 
				", gmtCreate=" + gmtCreate + "]";
	}

	
	
}
