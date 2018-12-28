package store.ae.dto.mall.goods;

import lombok.Data;

@Data
public class PathExposer {
	
	/**
	 * 是否开启秒杀
	 */
	private boolean exposed;
	
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
	private long paramId;
	
	/**
	 * 系统时间,毫秒
	 */
	private long nowTime;
	
	/**
	 * 开启时间
	 */
	private long start;
	
	/**
	 * 结束时间
	 */
	private long end;

	public PathExposer(boolean exposed, String msg, String pathMD5) {
		this.exposed = exposed;
		this.msg = msg;
		this.pathMD5 = pathMD5;
	}

	public PathExposer(boolean exposed, String msg, long paramId, long nowTime, long start, long end) {
		this.exposed = exposed;
		this.msg = msg;
		this.paramId = paramId;
		this.nowTime = nowTime;
		this.start = start;
		this.end = end;
	}
}
