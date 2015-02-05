package shopping_cart.services;

import shopping_cart.entities.Client;

public interface IClientServices {

	public Client addClient(String name, String user, String password);

	public Client login(String user, String password);

	public Client addCreditCard(String number, String securityCode, String description, Client client);

}
