/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class Polynomial implements Function, Integrandable {

	private LinearProduct[] polynomial;
	
	/**
	 * 
	 */
	public Polynomial(double[] polynomial) {
		this.polynomial = new LinearProduct[polynomial.length];
		for (int i = 0; i < polynomial.length; i++) {
			this.polynomial[i] = new LinearProduct(new Constant(polynomial[i]), new Exponent(polynomial.length - i - 1));
		}
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#apply(double)
	 */
	@Override
	public double apply(double number) {
		double sum = 0;
		for (int i = 0; i < polynomial.length; i++) {
			sum += polynomial[i].apply(number);
		}
		return sum;
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#derivative()
	 */
	@Override
	public Function derivative() {
		if (polynomial.length == 1) {
			return polynomial[0].derivative();
		}
		Sum derivativeSum = new Sum(polynomial[0].derivative(), polynomial[1].derivative());
		for (int i = 2; i < polynomial.length; i++) {
			derivativeSum = new Sum(derivativeSum, polynomial[i].derivative());
		}
		return derivativeSum;
	}
	
	@Override
	public Function integrand() {
		if (polynomial.length == 1) {
			return polynomial[0].integrand();
		}
		//Sum integralSum = new Sum(polynomial[0].integrand(), polynomial[1].integrand());
		Sum integralSum = new Sum(new Constant(0), new Constant(0));
		for (int i = 0; i < polynomial.length; i++) {
			integralSum = new Sum(integralSum, polynomial[i].integrand());
		}
		return integralSum;
	}

}
