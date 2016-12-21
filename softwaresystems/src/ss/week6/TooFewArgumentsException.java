/**
 * 
 */
package ss.week6;

/**
 * @author raalse
 *
 */
public class TooFewArgumentsException extends WrongArgumentException {

	/**
	 * 
	 */
	public TooFewArgumentsException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public TooFewArgumentsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public TooFewArgumentsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TooFewArgumentsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public TooFewArgumentsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
