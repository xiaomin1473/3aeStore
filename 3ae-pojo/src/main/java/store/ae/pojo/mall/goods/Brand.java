package store.ae.pojo.mall.goods;

import java.util.Date;

public class Brand {
	private long brandId;
	
	private String name;
	
	private String brand;
	
	private String imgUrl;
	
	/**
	 * 格林时间，创建日期
	 */
	private Date gmtCreate;

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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + 
				", name=" + name + 
				", brand=" + brand + 
				", imgUrl=" + imgUrl + 
				", gmtCreate=" + gmtCreate + "]";
	}

	
	
}
