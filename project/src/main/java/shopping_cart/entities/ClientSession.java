package shopping_cart.entities;

import java.util.Date;

public class ClientSession {

	private Client client;
	private String token;

	private Date beginTime;
	private Date endTime;

	public ClientSession() {
	}

	public ClientSession(Client client) {
		this.client = client;
		this.beginTime = new Date();
		this.token = generateToken();
		this.endTime = addThirtyMinutes(beginTime);
	}

	// TO-DO
	private String generateToken() {
		return "1234";
	}

	private Date addThirtyMinutes(Date date) {
		return new Date(date.getTime() + 1800000);
	}

	public boolean isValid() {
		return endTime.after(new Date());
	}

	public String getToken() {
		return this.token;
	}

	public Client getClient() {
		return this.client;
	}

	// public ShoppingCart getShoppingCart() {
	// if (client.getShoppingCart() == null) {
	// client.setShoppingCart(new ShoppingCart());
	// }
	//
	// return client.getShoppingCart();
	// }

	@Override
	public String toString() {
		return "{\"token\":\"" + getToken() + "\"}";
	}

}
