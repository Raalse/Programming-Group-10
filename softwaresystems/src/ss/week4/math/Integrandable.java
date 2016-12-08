/**
 * 
 */
package ss.week4.math;

/**
 * @author raalse
 *
 */
public interface Integrandable {
	
	public Function integrand();
}

/* P-4.11
 * There are functions where integrands have no "standard" rules of calculation.
 * Thus, we need a new Interface just for the ones that can be calculated.
 */ 
