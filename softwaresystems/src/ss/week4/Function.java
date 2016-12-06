/**
 * 
 */
package ss.week4;

/**
 * @author raalse
 *
 */
public interface Function {
	
	/**
	 * Executes the function to an argument <code>number</code> of type double.
	 * @param number
	 */
	public void apply(double number);
	
	public Function derivative(Function current);
	
	public String toString(Function function);
}
