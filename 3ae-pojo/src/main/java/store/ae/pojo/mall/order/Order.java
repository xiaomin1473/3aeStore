package store.ae.pojo.mall.order;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private Long orderId;
	
	private Long userId;
	
	private Long logisticsId;
	
	private Long categoryType;
	
	private Integer discountWay;
	
	private BigDecimal discount;
	
	private BigDecimal payment;
	
	private Integer invoice;
	
	private Integer orderStatus;
	
	private Long afterSaleStatus;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
