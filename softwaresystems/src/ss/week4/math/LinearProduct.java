/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class LinearProduct extends Product implements Function {

	private Constant function1;
	private Function function2;
	
	/**
	 * @param function1
	 * @param function2
	 */
	public LinearProduct(Constant function1, Function function2) {
		super(function1, function2);
		this.function1 = function1;
		this.function2 = function2;
	}
	
	@Override
	public Function derivative() {
		return new LinearProduct(function1, function2.derivative());
	}
}
