package entities;

public class CreditCard {

	private String number;
	private String client;

	public CreditCard() {
	}

	public CreditCard(String number, String client) {
		this.number = number;
		this.client = client;
	}

	public String getNumber() {
		return number;
	}

	public String getClient() {
		return client;
	}
}
