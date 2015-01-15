package entities;

import java.util.ArrayList;

import logic.PayStrategy;

public class Cart {
	private ArrayList<Appliance> appliances = new ArrayList<Appliance>();
	private double finalPrice = 0;
	private PayStrategy paymentMethod;

	public Cart() {
		this(null);
	}

	public Cart(PayStrategy paymentMethod) {
		this.setPaymentMethod(paymentMethod);
	}

	public void setPaymentMethod(PayStrategy paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void addAppliance(Appliance appliance) {
		this.appliances.add(appliance);
	}

	public ArrayList<Appliance> getAppliances() {
		return this.appliances;
	}

	public double getFinalPrice() {
		return this.finalPrice;
	}

	public void closeCart() {
		finalPrice = paymentMethod.getFinalPrice(appliances);
	}
}
