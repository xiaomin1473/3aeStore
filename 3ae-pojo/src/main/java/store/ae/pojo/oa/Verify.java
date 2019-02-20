package store.ae.pojo.oa;

import java.util.Date;

import lombok.Data;

@Data	
public class Verify {
	private Long verifyId;
	
	private String identifier;
	
	private String text1;
	
	private String text2;
	
	private String handler;
	
	private int verifyStatus;
	
	private String remark;
	
	private Date gmtCreate;
	
	private Date gmtModified;
}
