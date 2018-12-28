package store.ae.common.enums.mall.feast;

import lombok.Getter;

/**
 * @author sidtadpole
 * 
 * 使用枚举表示常量字段
 *
 */
@Getter
public enum SeckillStatEnum {
	SUCCESS(1, "秒杀成功"),
	END(0, "秒杀结束"),
	REPEAT_KILL(-1, "重复秒杀"),
	INNER_ERROR(-2, "系统异常"),
	DATA_REWRITE(-3, "数据篡改");
	
	private String stateInfo;

	private int state;

	private SeckillStatEnum(int state, String staeInfo) {
		this.state = state;
		this.stateInfo = staeInfo;
	}
	
	public static SeckillStatEnum stateof(int index) {
		for(SeckillStatEnum state : values()) {
			if(state.getState() == index) {
				return state;
			}
		}
		return null;
	}
}
