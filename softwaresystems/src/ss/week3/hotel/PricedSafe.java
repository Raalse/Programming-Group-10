package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedSafe extends Safe implements Item {

	private double price;
	
	public PricedSafe(double price) {
		this.price = price;
	}

	@Override
	public double getAmount() {
		return price;
	}
	
	public String getString() {
		return "This safe is priced at " + this.getAmount();
	}

}
