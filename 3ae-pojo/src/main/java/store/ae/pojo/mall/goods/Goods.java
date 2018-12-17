package store.ae.pojo.mall.goods;

import java.math.BigDecimal;

public class Goods {
	private long goodsId;
	
	private long category;
	
	private long brandId;
	
	private String name;
	
	private String props;
	
	private long businessId;
	
	private long number;
	
	private String unit;
	
	private BigDecimal price;
	
	private String imgUrl;

	public long getGoodsId() {
		return goodsId;
	}

	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProps() {
		return props;
	}

	public void setProps(String props) {
		this.props = props;
	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + 
				", category=" + category + 
				", brandId=" + brandId + 
				", name=" + name + 
				", props=" + props + 
				", businessId=" + businessId + 
				", number=" + number + 
				", unit=" + unit + 
				", price=" + price + 
				", imgUrl=" + imgUrl + "]";
	}

	

}
