package shopping_cart.services;

import shopping_cart.entities.Client;
import shopping_cart.entities.ClientSession;
import shopping_cart.entities.CreditCard;

public interface IClientServices {

	public Client addClient(Client client);

	public ClientSession login(String user, String password);

	public Client addCreditCard(String token, CreditCard creditCard);

}
