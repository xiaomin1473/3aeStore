package store.ae.pojo.mall.goods;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
	private long goodsId;
	
	private long goodsTypeId;
	
	private String name;
	
	private int number;
	
	private BigDecimal price;
	
	private Date startTime;
	
	private Date gmtCreate;

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public long getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(long goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + 
				", goodsTypeId=" + goodsTypeId + 
				", name=" + name + 
				", number=" + number + 
				", price=" + price + 
				", startTime=" + startTime + 
				", gmtCreate=" + gmtCreate + "]";
	}
	
	
}
