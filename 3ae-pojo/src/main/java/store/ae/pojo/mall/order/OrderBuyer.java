package store.ae.pojo.mall.order;

import java.util.Date;

import lombok.Data;

@Data
public class OrderBuyer {
	private Long orderId;
	
	private Long categoryType;
	
	private String userName;
	
	private String buyerName;
	
	private Long buyerPhone;
	
	private String buyerAddress;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
