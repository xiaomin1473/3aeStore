package store.ae.pojo.oa;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


@Data
public class Apply {
	private Long expensesId;
	
	/**
	 * 申请编号
	 */
	private String identifier;
	
	/**
	 * 申请时间
	 */
	private Date expensesGmt;
	
	/**
	 * 报支事项
	 */
	private String matter;
	
	/**
	 * 金额
	 */
	private BigDecimal amount;
	
	/**
	 * 处理人
	 */
	private String handler;
	
	/**
	 * 归属人
	 */
	private String ascriptor;
	
	/**
	 * 开票类型
	 */
	private String expensesType;
	
	/**
	 * 部门
	 */
	private String departmentType;
	
	/**
	 * 收款公司
	 */
	private String receiveCompany;
	
	/**
	 * 归属类别
	 */
	private String ascription;
	
	/**
	 * 项目编号
	 */
	private String projectNum;
	
	/**
	 * 项目名称
	 */
	private String projectName;
	
	/**
	 * 分类标识
	 */
	private String classType;
	
	/**
	 * 申请状态
	 */
	private int applyStatus;
	
	/**
	 * 备注
	 */
	private String remark;
	
	private Date gmtCreate;
	
	private Date gmtModified;
	
}
