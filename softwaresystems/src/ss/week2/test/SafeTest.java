package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Safe;

/**
 * Test program for Safe.
 * Lab Exercise SoftwareSystems
 * @author Radu Seteanu, Richard Santing
 * @version $Revision: 1.0 $
 */

public class SafeTest {

	/** Test variable for a <tt>Safe</tt>-object. */
    private Safe protectron;
    private String pass = "easyLife";
	
    /**Sets the instance variable <tt>hotel</tt> to a well-defined initial value. */
    
	@Before
	public void setUp() {
		protectron = new Safe(pass);
	}

	@Test
	public void testActivateWrongPassword() {
		protectron.activate("");
		assertFalse(protectron.isActive());
	}
	
	@Test
	public void testActivateCorrectPassword() {	
		protectron.activate(pass);
		assertTrue(protectron.isActive());
	}
	
	@Test
	public void testDeactivate() {
		protectron.deactivate();
		assertFalse(protectron.isActive());
	}
	
	@Test
	public void testOpenWrongPassword() {
		protectron.activate(pass);
		protectron.open("");
		assertFalse(protectron.isOpen());
	}
	
	@Test
	public void testOpenCorrectPassword() {
		protectron.activate(pass);
		protectron.open(pass);
		assertTrue(protectron.isOpen());
	}
	
	@Test
	public void testClose() {
		protectron.close();
		assertFalse(protectron.isOpen());
	}
	
	@Test
    public void testPassword() {
    	assertTrue(protectron.getPassword().testWord(pass));
	}
}


/*P-2.11 
- The most covered package is week2.hotel(42.4%).
- Most covered class is Password(94.4%), then comes Safe(84.7%) in second place (week2).
- The least covered classes are Hotel, Guest, Room (0%) (week2).
- The least covered packages are week1.test, week2, week1.hotel and week1 (0%).
- We can improve this by adding more tests for the highlighted lines.
- It's no problem that some classes are covered 0%,
 because we don't have tests for all of the classes (test classes).
*/