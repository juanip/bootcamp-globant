package shopping_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Client;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.exceptions.ClientNotFoundException;
import shopping_cart.repositories.ClientRepository;

@Component
@Scope(value = "singleton")
public class ClientDAO {

	@Autowired
	private ClientRepository clientRepository;

	public ClientDAO() {
	}

	public Client getClient(String user) {
		Client client = this.clientRepository.findByUser(user);

		if (client == null) {
			throw new ClientNotFoundException(user);
		}

		return client;
	}

	public Client addClient(String name, String user, String password) {
		ShoppingCart sc = new ShoppingCart();
		Client client = new Client(name, user, password, sc);
		sc.setClient(client);
		return this.clientRepository.save(client);
	}
}
