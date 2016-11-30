package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.Rectangle;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
	/** Test variable for a <tt>Rectangle</tt>-object. */
    private Rectangle small;
    /** Test variable for a <tt>Rectangle</tt>-object. */
	private Rectangle big;
    @Before
	public void setUp() {
		small = new Rectangle(10, 20);
		big = new Rectangle(50, 60);
	}
    
    /**
     * Tests initial values.
     */
    
    @Test
    public void testInitialcondition() {
    	assertEquals(10, small.length());
    	assertEquals(20, small.width());
    	assertEquals(50, big.length());
    	assertEquals(60, big.width());
    	assertEquals(200, small.area());
    	assertEquals(3000, big.area());
    	assertEquals(60, small.perimeter());
    	assertEquals(220, big.perimeter());
    }
    
    /**
     * Tests the changes in the small rectangle.
     */
    
    @Test
    public void testChanges() {
    	small = new Rectangle(30, 20);
    	assertEquals(30, small.length());
    	assertEquals(20, small.width());
    	assertEquals(600, small.area());
    	assertEquals(100, small.perimeter());
    }

}