package services;

import java.util.List;

import data.CartRepository;
import data.ProductRepository;
import entities.Cart;
import entities.CreditCard;
import entities.Product;

public class CartServices implements ICartServices {

	private final CartRepository cartRepository = CartRepository.getInstance();
	private final ProductRepository productRepository = ProductRepository.getInstance();

	@Override
	public Cart createCart() {
		return cartRepository.createCart();
	}

	@Override
	public Cart getCart(long id) {
		return cartRepository.getCart(id);
	}

	@Override
	public List<Product> getProducts(long id) {
		return cartRepository.getCart(id).getProductList();
	}

	@Override
	public Cart addProduct(long idCart, Product product) {
		Cart cart = cartRepository.getCart(idCart);
		cart.addProduct(productRepository.getProduct(product.getId()));

		return cart;
	}

	@Override
	public Cart performPayment(long id, CreditCard creditCard) {
		Cart cart = cartRepository.getCart(id);
		cart.performPayment(creditCard);

		return cart;
	}

}
