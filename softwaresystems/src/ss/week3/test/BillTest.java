package ss.week3.test;

import static org.junit.Assert.*;

import ss.week3.hotel.Bill;
import ss.week3.hotel.AnItem;
import org.junit.Before;
import org.junit.Test;

public class BillTest {

	private Bill testBill;
	private AnItem testItem;
	
	@Before
	public void setUp() throws Exception {
		testBill = new Bill(null);
		testItem = new AnItem("Whiskey", 10);
	}

	@Test
	public void testAnItem() { //Class implement of Item
		assertEquals(10, testItem.getAmount());
		assertEquals("Whiskey", testItem.toString());
	}

}
