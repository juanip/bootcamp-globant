package shopping_cart.services;

import shopping_cart.entities.Client;
import shopping_cart.entities.Order;
import shopping_cart.entities.ShoppingCart;

public interface ShoppingCartServices {

	public ShoppingCart getShoppingCart(Client client);

	public ShoppingCart addProduct(Long productId, int quantity, Client client);

	public Order buyProducts(Client client, String number);
}
