package ss.week1.test;

public class DollarsAndCentsCounter {
	public double counter = 0;
	
	public int dollars() {
		int dollars = (int) counter;
		if (dollars < 0) {
			return 0;
		}
		return dollars;
	}
	
	public int cents() {
		int cents = (int) (counter * 100) % 100;
		if (cents < 0) {
			return 0;
		}
		return cents;
	}
	
	public void add(int dollars, int cents) {
		counter += ((double) (100 * dollars + cents)) / 100;
	}
	
	public void reset() {
		counter = 0;
	}
}