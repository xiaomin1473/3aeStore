package store.ae.vo.oa;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class Expenses {
	
	private Long expensesId;
	
	private String identifier;
	
	private Date expensesGmt;
	
	private String matter;
	
	private BigDecimal amount;
	
	private String handler;
	
	private String ascriptor;
	
	private String expensesType;
	
	private String departmentType;
	
	private String receiveCompany;
	
	private String ascription;
	
	private String projectNum;
	
	private String projectName;
	
	private String classType;
	
	private int applyStatus;
	
	private String remark;
	
	private Long verifyId;
	
	private String textOne;
	
	private String textTwo;
	
	private int verifyStatus;
	
	private Long paymentId;
	
	private String paymentType;
	
	private String paymentBank;
	
	private Long voucher;
	
	private Date paymentGmt;
}
