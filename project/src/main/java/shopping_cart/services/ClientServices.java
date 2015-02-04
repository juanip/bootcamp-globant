package shopping_cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.ClientDAO;
import shopping_cart.dao.ClientSessionDAO;
import shopping_cart.dao.CreditCardDAO;
import shopping_cart.dao.ItemLineDAO;
import shopping_cart.dao.OrderDAO;
import shopping_cart.entities.Client;
import shopping_cart.entities.ClientSession;
import shopping_cart.entities.CreditCard;

@Service
@Configurable
public class ClientServices implements IClientServices {

	@Autowired
	private ClientDAO clientDAO;
	@Autowired
	private ClientSessionDAO clientSessionDAO;
	@Autowired
	private ItemLineDAO itemLinesDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CreditCardDAO creditCardDAO;

	public ClientServices() {
	}

	@Override
	public Client addClient(Client client) {
		return this.clientDAO.addClient(client.getName(), client.getUser(), client.getPassword());
	}

	@Override
	public ClientSession login(String user, String password) {
		return this.clientSessionDAO.getClientSession(user, password);
	}

	@Override
	@Transactional()
	public Client addCreditCard(String token, CreditCard cc) {
		Client client = clientSessionDAO.getClient(token);
		System.out.println("\n\nHi!\n\n" + client);
		creditCardDAO.createCreditCard(cc.getNumber(), cc.getSecurityCode(), cc.getDescription(), client);
		return client;
	}
}