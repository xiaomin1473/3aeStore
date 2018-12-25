package store.ae.dto.mall.feast;

import lombok.Data;

/**
 * @author sidtadpole
 *
 * @param <T>
 * 
 * 所有的ajax请求的返回类型，封装JSON结果
 */
@Data
public class SeckillResult<T> {
	
	private boolean success;
	
	private T data;
	
	private String error;
	

	public SeckillResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}


	public SeckillResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}
}
