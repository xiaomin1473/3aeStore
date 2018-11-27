package store.ae.pojo.mall.goods;

import java.util.Date;

public class GoodsImage {
	
	private long GoodsId;
	
	private String name;
	
	private int numberInfo;
	
	private int numberDetail;
	
	private String suffixType;
	
	private String urlsInfo;
	
	private String urlsDetail;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberInfo() {
		return numberInfo;
	}

	public void setNumberInfo(int numberInfo) {
		this.numberInfo = numberInfo;
	}

	public int getNumberDetail() {
		return numberDetail;
	}

	public void setNumberDetail(int numberDetail) {
		this.numberDetail = numberDetail;
	}

	public String getSuffixType() {
		return suffixType;
	}

	public void setSuffixType(String suffixType) {
		this.suffixType = suffixType;
	}

	public String getUrlsInfo() {
		return urlsInfo;
	}

	public void setUrlsInfo(String urlsInfo) {
		this.urlsInfo = urlsInfo;
	}

	public String getUrlsDetail() {
		return urlsDetail;
	}

	public void setUrlsDetail(String urlsDetail) {
		this.urlsDetail = urlsDetail;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	@Override
	public String toString() {
		return "GoodsImage [GoodsId=" + GoodsId + 
				", name=" + name + 
				", numberInfo=" + numberInfo + 
				", numberDetail=" + numberDetail + 
				", suffixType=" + suffixType + 
				", urlsInfo=" + urlsInfo + 
				", urlsDetail=" + urlsDetail + 
				", gmtCreate=" + gmtCreate + "]";
	}
}
