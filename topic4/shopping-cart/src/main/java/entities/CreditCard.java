package entities;

public class CreditCard {

	private String cardNumber;
	private String client;

	public CreditCard() {

	}

	public CreditCard(String cardNumber, String client) {
		this.cardNumber = cardNumber;
		this.client = client;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getClient() {
		return client;
	}
}
