package store.ae.vo.mall.goods.order;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class OrderDetailVo {
	
	@SerializedName("order")
	private long orderId;
	
	@SerializedName("user")
	private long userId;
	
	@SerializedName("uname")
	private String userName;
	
	@SerializedName("logistics")
	private long logisticsId;
	
	@SerializedName("sku")
	private long goodsSkuId;
	
	@SerializedName("type")
	private long categoryType;
	
	@SerializedName("way")
	private int discountWay;
	
	@SerializedName("discount")
	private BigDecimal discount;
	
	@SerializedName("payment")
	private BigDecimal payment;
	
	@SerializedName("invoice")
	private int invoice;
	
	@SerializedName("state")
	private int orderStatus;
	
	@SerializedName("after_state")
	private long afterSaleStatus;
	
	@SerializedName("name")
	private String buyerName;
	
	@SerializedName("phone")
	private long buyerPhone;
	
	@SerializedName("address")
	private String buyerAddress;
	
	@SerializedName("sku_name")
	private String goodsName;
	
	@SerializedName("num")
	private int goodsNumber;
	
	@SerializedName("num_unit")
	private String unit;
	
	@SerializedName("price")
	private BigDecimal skuPrice;
	
	@SerializedName("price_unit")
	private String moneyUnit;
	
	@SerializedName("image_url")
	private String imgUrl;
	
	@SerializedName("create_time")
	private Date gmtCreate;

}