package shopping_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Client;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.exceptions.ClientNotFoundException;
import shopping_cart.exceptions.NameUnavailableException;
import shopping_cart.exceptions.UserUnavailableException;
import shopping_cart.exceptions.WrongPasswordException;
import shopping_cart.repositories.ClientRepository;

@Component
public class ClientDAO {

	@Autowired
	private ClientRepository clientRepository;

	public Client addClient(String name, String user, String password) {
		if (!this.userAvailable(user)) {
			throw new UserUnavailableException();
		}

		if (!this.nameAvailable(name)) {
			throw new NameUnavailableException();
		}

		ShoppingCart sc = new ShoppingCart();
		Client client = new Client(name, user, password, sc);
		return this.clientRepository.save(client);
	}

	private boolean nameAvailable(String name) {
		return (this.clientRepository.findByName(name) == null);
	}

	private boolean userAvailable(String user) {
		return (this.clientRepository.findByUser(user) == null);
	}

	public Client getClientByUser(String user) {
		Client client = this.clientRepository.findByUser(user);

		if (client == null) {
			throw new ClientNotFoundException(user);
		}

		return client;
	}

	public Client getClient(Client client) {
		return getClientByUser(client.getUser());
	}

	public Client login(String user, String password) {
		Client client = getClientByUser(user);

		if (client.isValidPassword(password)) {
			return client;
		} else {
			throw new WrongPasswordException();
		}
	}
}
