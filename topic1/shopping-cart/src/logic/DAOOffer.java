package logic;

import java.util.ArrayList;

import entities.Offer;

public class DAOOffer implements MailNotificationSubject {

	private static DAOOffer daoOffers;

	public static DAOOffer getDAOOffers() {
		if (daoOffers == null) {
			daoOffers = new DAOOffer();
		}

		return daoOffers;
	}

	private ArrayList<Offer> offers = new ArrayList<Offer>();
	private ArrayList<MailNotificactionObserver> observers = new ArrayList<MailNotificactionObserver>();

	// singleton
	private DAOOffer() {

	}

	public void addOffer(Offer offer) {
		this.offers.add(offer);
		doNotify(offer);
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
			o.newItem(item);
		}
	}

	public Offer getOffer(int code) {
		for (Offer o : this.offers) {
			if (o.getCode() == code) {
				return o;
			}
		}

		throw new RuntimeException("Offer not found!");
	}

}