/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public interface Function {
	
	/**
	 * Executes the function to an argument <code>number</code> of type double.
	 * @param number
	 */
	public double apply(double number);
	
	public Function derivative();
	
	public String toString();
}
