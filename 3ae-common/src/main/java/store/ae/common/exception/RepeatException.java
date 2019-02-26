package store.ae.common.exception;

/**
 * @author sidtadpole
 * 
 * 重复异常
 *
 */
public class RepeatException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RepeatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
