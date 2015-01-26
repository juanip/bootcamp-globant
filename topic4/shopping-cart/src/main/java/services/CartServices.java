package services;

import java.util.List;

import entities.Cart;
import entities.CreditCard;
import entities.Product;

public interface CartServices {

	public abstract Cart createCart();

	public abstract Cart getCart(long id);

	public abstract List<Product> getProducts(long id);

	public abstract Cart addProduct(long idCart, Product product);

	public abstract Cart performPayment(long id, CreditCard creditCard);

}