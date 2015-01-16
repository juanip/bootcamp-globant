package logic;

import java.util.ArrayList;

import entities.Item;

public class Mailist implements MailNotificactionObserver {

	private static Mailist mailist;
	private ArrayList<Mail> mails = new ArrayList<Mail>();

	public static Mailist getMailist() {
		if (mailist == null) {
			mailist = new Mailist();
		}

		return mailist;
	}

	// singleton
	private Mailist() {
	}

	@Override
	public void newItem(MailNotificationSubject item) {
		String subject = "New Item";
		String message = "This item has been added:\n" + item.toString() + "\nList price: $" + ((Item) item).getListPrice();

		mails.add(new Mail(subject, message));
	}

	@Override
	public void priceChanged(MailNotificationSubject item) {
		String subject = "Price changed";
		String message = "Item:\n" + item.toString() + "\nList price: $" + ((Item) item).getListPrice();

		mails.add(new Mail(subject, message));
	}

	@Override
	public void newTransaction(MailNotificationSubject cart) {
		String subject = "New transaction";
		String message = "Transaction:\n" + cart.toString();

		mails.add(new Mail(subject, message));
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("Mails:");
		for (Mail mail : this.mails) {
			sb.append("\n" + mail + "\n");
		}

		return sb.toString();
	}

}
