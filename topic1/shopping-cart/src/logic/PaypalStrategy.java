package logic;

import java.util.ArrayList;

import entities.Item;

public class PaypalStrategy implements PayStrategy {

	private String email;
	private String pass;

	public PaypalStrategy(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPass() {
		return this.pass;
	}

	@Override
	public double getFinalPrice(ArrayList<Item> appliances) {
		Item cheapest = appliances.get(0);
		double finalPrice = 0;

		for (Item a : appliances) {
			if (a.getListPrice() < cheapest.getListPrice()) {
				cheapest = a;
			}
		}

		for (Item a : appliances) {
			if (!a.equals(cheapest)) {
				finalPrice += a.getListPrice();
			}
		}

		return finalPrice;
	}

	@Override
	public String toString() {
		return "Paypal";
	}
}
