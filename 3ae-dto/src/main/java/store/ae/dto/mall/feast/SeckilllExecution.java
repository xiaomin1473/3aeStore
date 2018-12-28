package store.ae.dto.mall.feast;

import lombok.Data;
import store.ae.common.enums.mall.feast.SeckillStatEnum;
import store.ae.pojo.mall.feast.SeckillSuccess;

/**
 * @author sidtadpole
 * 
 * 封装秒杀执行后的结果
 *
 */
@Data
public class SeckilllExecution {
	private long seckillId;
	
	/**
	 * 秒杀状态
	 */
	private int state;
	
	/**
	 * 秒杀提示
	 */
	private String stateInfo;
	
	/**
	 * 秒杀成功对象
	 */
	private SeckillSuccess seckillSuccess;


	public SeckilllExecution(long seckillId, SeckillStatEnum statEnum, SeckillSuccess seckillSuccess) {
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStateInfo();
		this.seckillSuccess = seckillSuccess;
	}
	
	public SeckilllExecution(long seckillId, SeckillStatEnum statEnum) {
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStateInfo();
	}
}
