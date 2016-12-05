package ss.week3.test;

import ss.week3.hotel.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BillTest {

	private Bill testBill;
	private AnItem testItem;
	private AnItem testItem2;
	
	@Before
	public void setUp() throws Exception {
		testBill = new Bill(null);
		testItem = new AnItem("Whiskey", 10);
		testItem2 = new AnItem("ChocolateBar", 4.99);
	}

	@Test
	public void testBill() throws Exception {
		assertEquals(0, testBill.getSum(), 0);
		testBill.newItem(testItem);
		assertEquals(10, testBill.getSum(), 0);
		testBill.newItem(testItem2);
		assertEquals(14.99, testBill.getSum(), 0);
	}
}


/*
 * Element		Coverage	Covered Instructions	Missed Instructions		Total Instructions
 * Bill.java		72.2 %	    26	 					10						36
 */
