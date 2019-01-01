package store.ae.dto.mall.feast;

import lombok.Data;

/**
 * @author sidtadpole
 * 
 * 暴露秒杀地址DTO
 *
 */

@Data
public class Exposer {
	
	/**
	 * 是否开启秒杀
	 */
	private boolean exposed;
	
	/**
	 * md5加密接口
	 */
	private String md5;
	
	/**
	 * id
	 */
	private Long seckillId;
	
	/**
	 * 系统时间,毫秒
	 */
	private Long nowTime;
	
	/**
	 * 开启时间
	 */
	private Long start;
	
	/**
	 * 结束时间
	 */
	private Long end;
	

	public Exposer(boolean exposed, String md5, Long seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, Long seckillId, Long nowTime, Long start, Long end) {
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.nowTime = nowTime;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposed, Long seckillId) {
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

}
