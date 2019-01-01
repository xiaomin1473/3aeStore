package store.ae.vo.mall.goods.order;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class OrderDetailVo {
	
	@SerializedName("order")
	private Long orderId;
	
	@SerializedName("user")
	private Long userId;
	
	@SerializedName("uname")
	private String userName;
	
	@SerializedName("logistics")
	private Long logisticsId;
	
	@SerializedName("sku")
	private Long goodsSkuId;
	
	@SerializedName("type")
	private Long categoryType;
	
	@SerializedName("way")
	private Integer discountWay;
	
	@SerializedName("discount")
	private BigDecimal discount;
	
	@SerializedName("payment")
	private BigDecimal payment;
	
	@SerializedName("invoice")
	private Integer invoice;
	
	@SerializedName("state")
	private Integer orderStatus;
	
	@SerializedName("after_state")
	private Long afterSaleStatus;
	
	@SerializedName("name")
	private String buyerName;
	
	@SerializedName("phone")
	private Long buyerPhone;
	
	@SerializedName("address")
	private String buyerAddress;
	
	@SerializedName("sku_name")
	private String goodsName;
	
	@SerializedName("num")
	private Integer goodsNumber;
	
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