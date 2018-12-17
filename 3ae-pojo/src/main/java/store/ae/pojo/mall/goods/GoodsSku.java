package store.ae.pojo.mall.goods;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsSku {
	private long goodsSkuId;
	
	private long goodsId;
	
	private long category;
	
	private String name;
	
	private String color;
	
	private String model;
	
	private String format;
	
	private String param;
	
	private String props;
	
	private String weight;
	
	private String imgUrl;
	
	private BigDecimal market;
	
	private BigDecimal mall;
	
	private long number;
	
	private Date gmtCreate;

	public long getGoodsSkuId() {
		return goodsSkuId;
	}

	public void setGoodsSkuId(long goodsSkuId) {
		this.goodsSkuId = goodsSkuId;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getProps() {
		return props;
	}

	public void setProps(String props) {
		this.props = props;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public BigDecimal getMarket() {
		return market;
	}

	public void setMarket(BigDecimal market) {
		this.market = market;
	}

	public BigDecimal getMall() {
		return mall;
	}

	public void setMall(BigDecimal mall) {
		this.mall = mall;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "GoodsSku [goodsSkuId=" + goodsSkuId + 
				", goodsId=" + goodsId + 
				", category=" + category + 
				", name=" + name + 
				", color=" + color + 
				", model=" + model + 
				", format=" + format + 
				", param=" + param + 
				", props=" + props + 
				", weight=" + weight + 
				", imgUrl=" + imgUrl + 
				", market=" + market + 
				", mall=" + mall + 
				", number=" + number + 
				", gmtCreate=" + gmtCreate + "]";
	}
	
	
}
