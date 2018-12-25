package store.ae.pojo.mall.order;

import java.util.Date;

import lombok.Data;

@Data
public class OrderUser {
	private long orderId;
	
	private long userId;
	
	private long categoryType;
	
	private String userName;
	
	private String deliveryName;
	
	private long deliveryPhone;
	
	private String address;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
