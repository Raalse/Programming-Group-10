/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class Exponent implements Function {

	private int power;
	
	/**
	 * 
	 */
	public Exponent(int power) {
		this.power = power;
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#apply(double)
	 */
	@Override
	public double apply(double number) {
		if (power == 0) {
			return 1;
		}
		double help = number;
		for (int i = 2; i <= power; i++) {
			help = help * number;
		}
		return help;
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#derivative()
	 */
	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(power), new Exponent(power - 1));
	}
	
	@Override
	public String toString() {
		return power + "";
	}
	
}
