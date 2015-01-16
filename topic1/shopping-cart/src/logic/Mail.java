package logic;

import java.util.Date;

public class Mail {

	private final Date date;
	private String subject;
	private String message;

	public Mail(Date date, String subject, String message) {
		this.date = date;
		this.subject = subject;
		this.message = message;
	}

	public Mail(String subject, String message) {
		this(new Date(), subject, message);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Date:" + date + "\nSubject: " + subject + "\nMessage: " + message;
	}

}
