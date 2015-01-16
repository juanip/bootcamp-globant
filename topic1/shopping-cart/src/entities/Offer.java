package entities;

import java.util.ArrayList;

import logic.MailNotificactionObserver;
import logic.MailNotificationSubject;

public class Offer implements Item, MailNotificationSubject {

	private ArrayList<MailNotificactionObserver> observers = new ArrayList<MailNotificactionObserver>();
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
		doNotify(this);
	}

	public Offer(int code, String name, MailNotificactionObserver observer) {
		this(code, name, 1);
		this.addObserver(observer);
	}

	public int getCode() {
		return this.code;
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
			o.priceChanged(item);
		}

	}
}
