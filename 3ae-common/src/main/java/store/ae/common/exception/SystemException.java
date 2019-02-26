package store.ae.common.exception;

/**
 * @author sidtadpole
 * 
 * 系统异常（运行期异常）
 * 
 * 1.编译期异常
 * 2.运行期异常。spring声明式事务只接收运行期异常回滚策略
 *
 */
public class SystemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SystemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
