package logic;

import java.util.ArrayList;

import entities.Appliance;

public class CashStrategy implements PayStrategy {

	// 90% discount
	public final static double DISCOUNT = 0.1;

	@Override
	public double getFinalPrice(ArrayList<Appliance> appliances) {
		Appliance mostExpensive = appliances.get(0);
		double finalPrice = 0;

		for (Appliance a : appliances) {
			if (a.getListPrice() > mostExpensive.getListPrice()) {
				mostExpensive = a;
			}
		}

		for (Appliance a : appliances) {
			if (!a.equals(mostExpensive)) {
				finalPrice += a.getListPrice();
			}
		}

		finalPrice += mostExpensive.getListPrice() * DISCOUNT;

		return finalPrice;
	}

}
