/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public class Sum implements Function {

	private Function function1;
	private Function function2;
	
	/**
	 * 
	 */
	public Sum(Function function1, Function function2) {
		this.function1 = function1;
		this.function2 = function2;
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#apply(double)
	 */
	@Override
	public double apply(double number) {
		return function1.apply(number) + function2.apply(number);
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#derivative()
	 */
	@Override
	public Function derivative() {
		return new Sum(function1.derivative(), function2.derivative());
	}

	/* (non-Javadoc)
	 * @see ss.week4.math.Function#toString(ss.week4.math.Function)
	 */
	@Override
	public String toString() {
		return function1.toString() + " + " + function2.toString();
	}
}
