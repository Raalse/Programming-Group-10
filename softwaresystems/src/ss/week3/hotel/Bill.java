package ss.week3.hotel;

import java.io.PrintStream;

public class Bill {
	
	public Item item;
	public PrintStream stream;
	private double sum = 0;
	
	public static interface Item {
		double getAmount();
	}

	public Bill(PrintStream theOutStream) { //System.out for console output
		stream = theOutStream;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void close() {
		if (stream != null) {
			stream.print(sum);
		}
	}
	
	public void newItem(Bill.Item item) {
		this.item = item;
		sum += item.getAmount();
		if (stream != null) {
			stream.print(item);
		}
	}

}
