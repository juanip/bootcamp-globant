package shopping_cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.ClientDAO;
import shopping_cart.dao.CreditCardDAO;
import shopping_cart.dao.ItemLineDAO;
import shopping_cart.dao.OrderDAO;
import shopping_cart.entities.Client;

@Service
@Configurable
public class ClientServicesImpl implements ClientServices {

	@Autowired
	private ClientDAO clientDAO;
	@Autowired
	private ItemLineDAO itemLinesDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CreditCardDAO creditCardDAO;

	public ClientServicesImpl() {
	}

	@Override
	public Client addClient(String name, String user, String password) {
		return this.clientDAO.addClient(name, user, password);
	}

	@Override
	public Client login(String user, String password) {
		return this.clientDAO.login(user, password);
	}

	@Override
	@Transactional()
	public Client addCreditCard(String number, String securityCode, String description, Client client) {
		client = clientDAO.getClient(client);
		creditCardDAO.createCreditCard(number, securityCode, description, client);
		return client;
	}
}