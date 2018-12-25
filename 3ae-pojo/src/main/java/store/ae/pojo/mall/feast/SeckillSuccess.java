package store.ae.pojo.mall.feast;

import java.util.Date;

import lombok.Data;

@Data
public class SeckillSuccess {
	private long seckillId;
	
	private long userPhone;
	
	private short state;
	
	private Date gmtCreate;
	
	// 多对一
	private Seckill seckill;
}
