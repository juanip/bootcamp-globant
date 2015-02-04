package shopping_cart.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Client;
import shopping_cart.entities.ClientSession;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.exceptions.ClientSessionNotFound;
import shopping_cart.exceptions.WrongPasswordException;

@Component
@Scope(value = "singleton")
public class ClientSessionDAO {

	@Autowired
	private ClientDAO clientDAO;

	private List<ClientSession> sessions = new ArrayList<ClientSession>();

	public ClientSession getClientSession(String user, String password) {
		Client client = clientDAO.getClient(user);

		if (!client.getPassword().equals(password)) {
			throw new WrongPasswordException();
		}

		ClientSession cs = new ClientSession(client);
		this.sessions.add(cs);
		return cs;
	}

	public ClientSession getClientSession(String token) {
		for (ClientSession cs : this.sessions) {
			if (cs.getToken().equals(token)) {
				return cs;
			}
		}

		throw new ClientSessionNotFound();
	}

	public Client getClient(String token) {
		ClientSession cs = getClientSession(token);
		return clientDAO.getClient(cs.getClient().getUser());
	}

	public ShoppingCart getShoppingCart(String token) {
		return getClient(token).getShoppingCart();
	}
}
