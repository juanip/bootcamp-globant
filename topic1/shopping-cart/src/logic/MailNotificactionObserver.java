package logic;


public interface MailNotificactionObserver {

	public void newItem(MailNotificationSubject item);

	public void priceChanged(MailNotificationSubject item);

	public void newTransaction(MailNotificationSubject cart);
}
