package shopping_cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.ClientDAO;
import shopping_cart.dao.CreditCardDAO;
import shopping_cart.dao.ItemLineDAO;
import shopping_cart.dao.OrderDAO;
import shopping_cart.dao.ProductDAO;
import shopping_cart.dao.ShoppingCartDAO;
import shopping_cart.entities.Client;
import shopping_cart.entities.CreditCard;
import shopping_cart.entities.ItemLine;
import shopping_cart.entities.Order;
import shopping_cart.entities.Product;
import shopping_cart.entities.ShoppingCart;

@Service
@Configurable
public class ShoppingCartServices implements IShoppingCartServices {

	@Autowired
	private ClientDAO clientDAO;
	@Autowired
	private ItemLineDAO itemLineDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;
	@Autowired
	private CreditCardDAO creditCardDAO;

	@Override
	public ShoppingCart getShoppingCart(Client client) {
		return clientDAO.getClient(client).getShoppingCart();
	}

	@Override
	@Transactional
	public ShoppingCart addProduct(Long productId, int quantity, Client client) {
		ShoppingCart shoppingCart = getShoppingCart(client);

		Product product = productDAO.getProduct(productId);

		itemLineDAO.createItemLine(product, quantity, shoppingCart);

		shoppingCart.updateTotal();

		return shoppingCartDAO.save(shoppingCart);
	}

	@Override
	@Transactional
	public Order buyProducts(Client client, String number) {
		// get attached client
		client = clientDAO.getClient(client);

		CreditCard creditCard = creditCardDAO.getCreditCard(number);

		// make new order
		Order order = orderDAO.createOrder(client, creditCard);

		ShoppingCart shoppingCart = getShoppingCart(client);

		for (ItemLine il : shoppingCart.getItemLines()) {
			il.setOrder(order);
		}

		order.setTotal(shoppingCart.getTotal());

		client.setShoppingCart(new ShoppingCart());

		return order;
	}
}
