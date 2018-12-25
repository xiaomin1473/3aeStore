package store.ae.pojo.mall.feast;

import java.util.Date;

import lombok.Data;

/**
 * @author sidtadpole
 *
 */
@Data
public class Seckill {
	private long seckillId;
	
	private String name;
	
	private int number;
	
	private Date startTime;

	private Date endTime;
	
	private Date gmtCreate;

}
