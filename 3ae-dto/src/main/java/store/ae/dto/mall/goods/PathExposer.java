package store.ae.dto.mall.goods;

import lombok.Data;

@Data
public class PathExposer {
	
	/**
	 * 是否开启秒杀
	 */
	private Boolean exposed;
	
	/**
	 * 提示信息
	 */
	private String msg;
	
	/**
	 * md5加密地址
	 */
	private String pathMD5;
	
	/**
	 * id
	 */
	private Long paramId;
	
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

	public PathExposer(boolean exposed, String msg, String pathMD5) {
		this.exposed = exposed;
		this.msg = msg;
		this.pathMD5 = pathMD5;
	}

	public PathExposer(boolean exposed, String msg, Long paramId, Long nowTime, Long start, Long end) {
		this.exposed = exposed;
		this.msg = msg;
		this.paramId = paramId;
		this.nowTime = nowTime;
		this.start = start;
		this.end = end;
	}
}
