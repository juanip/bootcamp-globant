package data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entities.Cart;

public class CartRepositoryTest {

	private CartRepository cartRepository = CartRepository.getInstance();

	@Test
	public void testCreateCart() {
		Cart cart = cartRepository.createCart();
		assertEquals((long) 0, cart.getId());

		cart = cartRepository.createCart();
		assertEquals((long) 1, cart.getId());
	}

}
