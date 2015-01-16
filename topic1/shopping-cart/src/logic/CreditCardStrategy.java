package logic;

import java.util.ArrayList;

import entities.Item;

public class CreditCardStrategy implements PayStrategy {

	// 10% discount
	public final static double DISCOUNT = 0.9;

	private String name;
	private String creditCardNumber;

	public CreditCardStrategy(String name, String creditCardNumber) {
		this.name = name;
		this.creditCardNumber = creditCardNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getCreditCardNumber() {
		return this.creditCardNumber;
	}

	@Override
	public double getFinalPrice(ArrayList<Item> appliances) {
		double finalPrice = 0;

		for (Item a : appliances) {
			finalPrice += a.getListPrice();
		}

		return finalPrice * DISCOUNT;
	}

	@Override
	public String toString() {
		return "Credit Card";
	}

}
