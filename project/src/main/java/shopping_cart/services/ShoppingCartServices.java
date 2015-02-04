package shopping_cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.ClientSessionDAO;
import shopping_cart.dao.ItemLineDAO;
import shopping_cart.dao.OrderDAO;
import shopping_cart.dao.ProductDAO;
import shopping_cart.dao.ShoppingCartDAO;
import shopping_cart.entities.CreditCard;
import shopping_cart.entities.Order;
import shopping_cart.entities.Product;
import shopping_cart.entities.ShoppingCart;

@Service
@Configurable
public class ShoppingCartServices implements IShoppingCartServices {

	@Autowired
	private ClientSessionDAO clientSessionDAO;
	@Autowired
	private ItemLineDAO itemLineDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;

	@Override
	public ShoppingCart getShoppingCart(String token) {
		return clientSessionDAO.getShoppingCart(token);
	}

	@Override
	@Transactional
	public ShoppingCart addProduct(String token, Long productId, int quantity) {
		ShoppingCart sc = getShoppingCart(token);

		Product product = productDAO.getProduct(productId);
		itemLineDAO.createItemLine(product, quantity, sc);

		return shoppingCartDAO.updateTotal(sc);
	}

	// TO-DO
	@Override
	public Order buyProducts(String token, CreditCard creditCard) {

		return null;
	}
}
