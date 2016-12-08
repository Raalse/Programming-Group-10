/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class Constant implements Function, Integrandable {

	
	private double value;
	
	/**
	 * 
	 */
	public Constant(double constant) {
		value = constant;
	}

	/* (non-Javadoc)
	 * @see ss.week4.Function#apply(double)
	 */
	@Override
	public double apply(double number) {
		return value;

	}

	/* (non-Javadoc)
	 * @see ss.week4.Function#derivative(ss.week4.Function)
	 */
	@Override
	public Function derivative() {
		return new Constant(0);
	}

	/* (non-Javadoc)
	 * @see ss.week4.Function#toString(ss.week4.Function)
	 */
	@Override
	public String toString() {
		return "" + value;
	}
	
	@Override
	public Function integrand() {
		return new LinearProduct(this, new Exponent(1));
	}

}
