/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class Polynomial implements Function {

	private LinearProduct[] polynomial;
	
	/**
	 * 
	 */
	public Polynomial(double[] polynomial) {
		for (int i = 0; i < polynomial.length; i++) {
			this.polynomial[i] = new LinearProduct(new Constant(polynomial[i]), new Exponent(polynomial.length - i));
		}
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#apply(double)
	 */
	@Override
	public double apply(double number) {
		double sum = 0;
		for (int i = 0; i < number; i++) {
			sum += polynomial[i].apply(number);
		}
		return sum;
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#derivative()
	 */
	@Override
	public Function derivative() {
		Sum derivativeSum = new Sum(polynomial[0].derivative(), polynomial[1].derivative());
		for (int i = 2; i < polynomial.length; i++) {
			derivativeSum = new Sum(derivativeSum, polynomial[i].derivative());
		}
		return derivativeSum;
	}

}
