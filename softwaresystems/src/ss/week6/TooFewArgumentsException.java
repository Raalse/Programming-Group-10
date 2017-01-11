/**
 * 
 */
package ss.week6;

/**
 * @author raalse
 *
 */
public class TooFewArgumentsException extends WrongArgumentException {

	@Override
	public String getMessage() {
		return "error: must pass two command line arguments";
	}
	
}
