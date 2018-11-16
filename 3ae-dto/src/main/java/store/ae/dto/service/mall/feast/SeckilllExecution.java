package store.ae.dto.service.mall.feast;

import store.ae.enums.mall.feast.SeckillStatEnum;
import store.ae.pojo.mall.feast.SeckillSuccess;

/**
 * @author sidtadpole
 * 
 * 封装秒杀执行后的结果
 *
 */
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
	
	
	
	@Override
	public String toString() {
		return "SeckilllExecution [" + 
				"seckillId=" + seckillId + 
				", state=" + state + 
				", stateInfo=" + stateInfo + 
				", seckillSuccess=" + seckillSuccess + 
				"]";
	}


	public SeckilllExecution(long seckillId, SeckillStatEnum statEnum, SeckillSuccess seckillSuccess) {
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStaeInfo();
		this.seckillSuccess = seckillSuccess;
	}
	

	public SeckilllExecution(long seckillId, SeckillStatEnum statEnum) {
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getStaeInfo();
	}


	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SeckillSuccess getSeckillSuccess() {
		return seckillSuccess;
	}

	public void setSeckillSuccess(SeckillSuccess seckillSuccess) {
		this.seckillSuccess = seckillSuccess;
	}
	
	
}
