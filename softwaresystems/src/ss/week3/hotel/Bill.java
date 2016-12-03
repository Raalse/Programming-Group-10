package ss.week3.hotel;

public class Bill {
	
	public Item item;
	public java.io.PrintStream stream;
	private double sum = 0;
	
	public static interface Item {
		double getAmount();
	}

	public Bill(java.io.PrintStream theOutStream) { //System.out for console output
		stream = theOutStream;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void close() {
		stream.print(sum);
	}
	
	public void newItem(Bill.Item item) {
		this.item = item;
		sum += item.getAmount();
		if (stream != null) {
			stream.print(item);
		}
	}

}
