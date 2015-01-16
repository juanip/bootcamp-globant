package logic;

public interface MailNotificationSubject {

	public void addObserver(MailNotificactionObserver observer);

	public void removeObserver(MailNotificactionObserver observer);

	public void doNotify(MailNotificationSubject item);

}
