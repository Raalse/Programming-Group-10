package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class PricedRoom extends Room implements Item {

	private PricedSafe safe;
	private double price;
	
	public PricedRoom(int no, double roomPrice, double safePrice) {
		super(no, new PricedSafe(safePrice));
		price = roomPrice;
	}

	@Override
	public double getAmount() {
		return price;
	}
	
	@Override
	public String toString() {
		return "The price per nights is: " + getAmount();
	}

}
