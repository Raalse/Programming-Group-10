/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class LinearProduct extends Product implements Function {
	
	/**
	 * @param function1
	 * @param function2
	 */
	public LinearProduct(Constant function1, Function function2) {
		super(function1, function2);
	}
	
	@Override
	public Function derivative() {
		return new LinearProduct((Constant) function1, function2.derivative());
	}
}
