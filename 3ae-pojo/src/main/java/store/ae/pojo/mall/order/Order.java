package store.ae.pojo.mall.order;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private long orderId;
	
	private long logisticsId;
	
	private long categoryType;
	
	private int discountWay;
	
	private BigDecimal discount;
	
	private BigDecimal payment;
	
	private int invoice;
	
	private int orderStatus;
	
	private long afterSaleStatus;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
