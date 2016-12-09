/**
 * 
 */
package ss.week4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
//import ss.week4.math.Constant;
//import ss.week4.math.Product;
import ss.week4.math.Sum;
import ss.week4.math.Polynomial;

/**
 * @author raalse
 *
 */
public class PolynomialTest {

	private static final double DELTA = 1e-15;
	private static final double CONSTANT_VALUE = 5;
	private Polynomial polynomial;
	private double[] arrayz = new double[4];
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		for (int i = 0; i <= 3; i++) {
			arrayz[i] = i;
		}
		polynomial = new Polynomial(arrayz);
	}

	@Test
	public void testApply() {
		assertEquals(38, polynomial.apply(CONSTANT_VALUE), DELTA); // x^2 + 2x + 3;
	}
	
	@Test
	public void testDerivative() {
		assertTrue(polynomial.derivative() instanceof Sum);
		assertEquals(12, polynomial.derivative().apply(CONSTANT_VALUE), DELTA);
	}

	
	@Test
	public void testIntegrand() {
		assertTrue(polynomial.integrand() instanceof Sum);
		assertEquals(81.6, polynomial.integrand().apply(CONSTANT_VALUE), DELTA);
	}

}
