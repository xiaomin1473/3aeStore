package store.ae.pojo.mall.order;

import java.util.Date;

import lombok.Data;

@Data
public class OrderBuyer {
	private long orderId;
	
	private long categoryType;
	
	private String userName;
	
	private String buyerName;
	
	private long buyerPhone;
	
	private String buyerAddress;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
