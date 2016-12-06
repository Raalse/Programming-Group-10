package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedSafe extends Safe implements Item {

	private double price;
	
	public PricedSafe(double safePrice) {
		price = safePrice;
	}

	@Override
	public double getAmount() {
		return price;
	}
	
	public String toString() {
		return "This safe is priced at " + getAmount();
	}

}
