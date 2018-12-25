package store.ae.dto.mall.goods;

import lombok.Data;

@Data
public class CategoryResult<T> {
	
	/**
	 * 	错误码
	 */
	private Integer code;
	
	/**
	 *  错误提示信息
	 */
	private String msg;
	
	/**
	 *  页面返回数据
	 */
	private T data;
	
}
