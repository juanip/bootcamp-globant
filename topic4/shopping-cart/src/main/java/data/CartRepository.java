package data;

import java.util.ArrayList;
import java.util.List;

import entities.Cart;

public class CartRepository {

	private static CartRepository instance;

	public static CartRepository getInstance() {
		if (instance == null) {
			instance = new CartRepository();
		}
		return instance;
	}

	private List<Cart> carts = new ArrayList<Cart>();

	private CartRepository() {
	}

	public Cart getCart(long id) {
		for (Cart c : carts) {
			if (c.getId() == id) {
				return c;
			}
		}

		throw new CartNotFoundException(id);
	}

	public Cart createCart() {
		long id = 0;
		if (carts.size() > 0) {
			id = carts.get(carts.size() - 1).getId() + 1;
		}

		Cart cart = new Cart(id);
		carts.add(cart);

		return cart;

	}

	class CartNotFoundException extends RuntimeException {
		public CartNotFoundException(long id) {
			super("Cart " + id + " does not exist.");
		}
	}
}
