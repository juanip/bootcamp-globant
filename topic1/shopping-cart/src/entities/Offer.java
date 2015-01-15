package entities;

import java.util.ArrayList;

public class Offer implements Item {

	private ArrayList<Item> offers = new ArrayList<Item>();
	private double discount;
	private final int code;
	private final String name;

	public Offer(int code, String name, double discount) {
		this.code = code;
		this.name = name;
		setDiscount(discount);
	}

	public Offer(int code, String name) {
		this(code, name, 1);
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void addOffer(Item offer) {
		this.offers.add(offer);
	}

	public void removeOffer(Item offer) {
		this.offers.remove(offer);
	}

	public ArrayList<Item> getOffers() {
		return this.offers;
	}

	public double getListPrice() {
		double price = 0;

		for (Item i : this.offers) {
			price += i.getListPrice();
		}

		return price * this.discount;
	}

	public String getInfoListItems() {
		StringBuffer sb = new StringBuffer();

		sb.append(code + ". " + name);

		for (Item o : offers) {
			sb.append("\n   " + o.toString());
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		return getInfoListItems();
	}
}
