package entities;

import java.util.ArrayList;

import logic.MailNotificactionObserver;
import logic.MailNotificationSubject;

public abstract class Appliance implements Item, MailNotificationSubject {

	private ArrayList<MailNotificactionObserver> observers = new ArrayList<MailNotificactionObserver>();
	private final int serialNumber;
	private double listPrice;

	public Appliance(int serialNumber, double price) {
		this.serialNumber = serialNumber;
		setListPrice(price);
	}

	public Appliance(int serialNumber) {
		this(serialNumber, 0);
	}

	public Appliance(int serialNumber, double price, MailNotificactionObserver observer) {
		this(serialNumber, price);
		this.addObserver(observer);
	}

	public int getSerialNumber() {
		return this.serialNumber;
	}

	public double getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(double price) {
		this.listPrice = price;
		this.doNotify(this);
	}

	@Override
	public void doNotify(MailNotificationSubject item) {
		for (MailNotificactionObserver o : this.observers) {
			o.priceChanged(item);
		}
	}

	@Override
	public void addObserver(MailNotificactionObserver observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(MailNotificactionObserver observer) {
		this.observers.remove(observer);
	}

	public abstract String toString();

}
