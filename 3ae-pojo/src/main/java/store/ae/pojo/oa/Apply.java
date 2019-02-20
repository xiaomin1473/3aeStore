package store.ae.pojo.oa;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


@Data
public class Apply {
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
	
	private Date gmtCreate;
	
	private Date gmtModified;
	
}
