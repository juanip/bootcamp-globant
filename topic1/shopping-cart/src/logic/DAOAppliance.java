package logic;

import java.util.ArrayList;

import entities.Appliance;

public class DAOAppliance implements MailNotificationSubject {

	private static DAOAppliance daoAppliance;

	public static DAOAppliance getDAOAppliance() {
		if (daoAppliance == null) {
			daoAppliance = new DAOAppliance();
		}

		return daoAppliance;
	}

	private ArrayList<Appliance> appliances = new ArrayList<Appliance>();
	private ArrayList<MailNotificactionObserver> observers = new ArrayList<MailNotificactionObserver>();

	// singleton
	private DAOAppliance() {

	}

	public void addAppliance(Appliance appliance) {
		this.appliances.add(appliance);
		doNotify(appliance);
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

	public Appliance getAppliance(int serialNumber) {
		for (Appliance a : this.appliances) {
			if (a.getSerialNumber() == serialNumber) {
				return a;
			}
		}

		throw new RuntimeException("Appliance not found!");
	}

}
