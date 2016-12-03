package ss.week3.hotel;

import ss.week3.hotel.Bill.Item;

public class AnItem implements Item {

	private double price;
	private String text;
	
	public AnItem(String text, double amount) {
		price = amount;
		this.text = text;
	}

	@Override
	public double getAmount() {
		return price;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
