package store.ae.pojo.oa;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


@Data
public class Payment {
	private Long paymentId;
	
	private String identifier;
	
	private Long verifyId;
	
	private String paymentType;
	
	private String paymentBank;
	
	private BigDecimal amount;
	
	private Long voucher;
	
	private String handler;
	
	private String remark;
	
	private Date paymentGmt;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
