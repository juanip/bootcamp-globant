package entities;

import java.util.ArrayList;

import logic.MailNotificactionObserver;
import logic.MailNotificationSubject;
import logic.PayStrategy;

public class Cart implements MailNotificationSubject {
	private static int globalPaymentNumber;

	public static int generatePaymentNumber() {
		globalPaymentNumber++;
		return globalPaymentNumber;
	}

	public static void setPaymentNumber(int number) {
		globalPaymentNumber = number;
	}

	private ArrayList<MailNotificactionObserver> observers = new ArrayList<MailNotificactionObserver>();
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

	public Cart(PayStrategy paymentMethod, MailNotificactionObserver observer) {
		this(paymentMethod);
		this.addObserver(observer);
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
		doNotify(this);
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

	@Override
	public String toString() {
		return "Transaction " + getPaymentNumber() + " - " + this.paymentMethod + ":\n" + getInfoListItems() + "\nFinal price: $"
				+ getFinalPrice();
	}

	@Override
	public void addObserver(MailNotificactionObserver observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(MailNotificactionObserver observer) {
		this.observers.remove(observer);
	}

	@Override
	public void doNotify(MailNotificationSubject item) {
		for (MailNotificactionObserver o : this.observers) {
			o.newTransaction(item);
		}
	}
}
