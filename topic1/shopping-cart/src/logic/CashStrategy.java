package logic;

import java.util.ArrayList;

import entities.Item;

public class CashStrategy implements PayStrategy {

	// 90% discount
	public final static double DISCOUNT = 0.1;

	@Override
	public double getFinalPrice(ArrayList<Item> appliances) {
		Item mostExpensive = appliances.get(0);
		double finalPrice = 0;

		for (Item a : appliances) {
			if (a.getListPrice() > mostExpensive.getListPrice()) {
				mostExpensive = a;
			}
		}

		for (Item a : appliances) {
			if (!a.equals(mostExpensive)) {
				finalPrice += a.getListPrice();
			}
		}

		finalPrice += mostExpensive.getListPrice() * DISCOUNT;

		return finalPrice;
	}

}
