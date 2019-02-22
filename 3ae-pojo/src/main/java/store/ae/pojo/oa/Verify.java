package store.ae.pojo.oa;

import java.util.Date;

import lombok.Data;

@Data	
public class Verify {
	private Long verifyId;
	
	private String identifier;
	
	private String textOne;
	
	private String textTwo;
	
	private String handler;
	
	private int verifyStatus;
	
	private String remark;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
