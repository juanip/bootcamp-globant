package shopping_cart.services;

import shopping_cart.entities.CreditCard;
import shopping_cart.entities.Order;
import shopping_cart.entities.ShoppingCart;

public interface IShoppingCartServices {

	public ShoppingCart getShoppingCart(String token);

	public ShoppingCart addProduct(String token, Long productId, int quantity);

	public Order buyProducts(String token, CreditCard creditCard);
}
