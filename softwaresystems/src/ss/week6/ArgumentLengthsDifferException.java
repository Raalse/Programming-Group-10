/**
 * 
 */
package ss.week6;

/**
 * @author raalse
 *
 */
public class ArgumentLengthsDifferException extends TooFewArgumentsException {

	int a;
	int b;
	
	/**
	 * 
	 */
	public ArgumentLengthsDifferException(int a, int b) {
		this.a = a;
		this.b = b;
	}

	/**
	 * @param message
	 */
	public ArgumentLengthsDifferException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ArgumentLengthsDifferException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ArgumentLengthsDifferException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ArgumentLengthsDifferException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getMessage() {
		return "error: length of command line arguments "
                + "differs (" + a  + ", " + b  + ")";
	}

}
