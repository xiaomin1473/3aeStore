package store.ae.pojo.mall.feast;

import java.util.Date;

import lombok.Data;

/**
 * @author sidtadpole
 *
 */
@Data
public class Seckill {
	private Long seckillId;
	
	private String name;
	
	private Integer number;
	
	private Date startTime;

	private Date endTime;
	
	private Date gmtCreate;

}
