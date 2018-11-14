package store.ae.exception.mall.feast;

/**
 * @author sidtadpole
 * 
 * 重复秒杀异常（运行期异常）
 * 
 * 1.编译期异常
 * 2.运行期异常。spring声明式事务只接收运行期异常回滚策略
 *
 */
public class SeckillRepeatException extends SeckillException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeckillRepeatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeckillRepeatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
