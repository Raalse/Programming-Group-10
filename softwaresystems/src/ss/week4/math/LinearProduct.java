/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class LinearProduct extends Product implements Function, Integrandable {
	
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
	
	@Override
	public Function integrand() {
		if (function2 instanceof Integrandable) {
			return new LinearProduct((Constant) function1, ((Integrandable) function2).integrand());
		}
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
