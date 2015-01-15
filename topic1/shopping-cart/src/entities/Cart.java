package entities;

import java.util.ArrayList;

import logic.PayStrategy;

public class Cart {
	private static int globalPaymentNumber;

	public static int generatePaymentNumber() {
		globalPaymentNumber++;
		return globalPaymentNumber;
	}

	public static void setPaymentNumber(int number) {
		globalPaymentNumber = number;
	}

	private ArrayList<Item> appliances = new ArrayList<Item>();
	private double finalPrice = 0;
	private PayStrategy paymentMethod;
	private int paymentNumber;

	public Cart() {
		this(null);
	}

	public Cart(PayStrategy paymentMethod) {
		this.setPaymentMethod(paymentMethod);
	}

	public void setPaymentMethod(PayStrategy paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void addItem(Item item) {
		this.appliances.add(item);
	}

	public ArrayList<Item> getItem() {
		return this.appliances;
	}

	public double getFinalPrice() {
		return this.finalPrice;
	}

	public void closeCart() {
		finalPrice = paymentMethod.getFinalPrice(appliances);
		paymentNumber = generatePaymentNumber();
	}

	public String getInfoListItems() {
		StringBuffer sb = new StringBuffer();

		for (Item a : appliances) {
			sb.append("\n" + a.toString());
		}

		return sb.toString();
	}

	public int getPaymentNumber() {
		return this.paymentNumber;
	}
}
