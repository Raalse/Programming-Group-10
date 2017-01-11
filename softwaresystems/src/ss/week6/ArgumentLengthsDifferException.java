/**
 * 
 */
package ss.week6;

/**
 * @author raalse
 *
 */
public class ArgumentLengthsDifferException extends WrongArgumentException {

	int a;
	int b;
	
	public ArgumentLengthsDifferException(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String getMessage() {
		return "error: length of command line arguments "
                + "differs (" + a  + ", " + b  + ")";
	}
	
	public String getMessag2e() {
		return "error: length of command line arguments "
                + "differs (" + a  + ", " + b  + ")";
		//return "error: length of command line arguments";
	}

}
