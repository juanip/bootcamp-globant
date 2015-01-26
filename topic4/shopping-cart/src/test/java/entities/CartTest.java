package entities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CartTest {

	private Cart cart;
	private Product prod1;
	private Product prod2;

	@Before
	public void setUp() {
		cart = new Cart(1);
		prod1 = new Product(1, "1", 1);
		prod2 = new Product(2, "2", 2);
		cart.addProduct(prod1);
		cart.addProduct(prod2);
	}

	@Test
	public void testGetProductList() {
		List<Product> prods = new ArrayList<Product>();
		prods.add(prod1);
		prods.add(prod2);

		assertEquals(prods, cart.getProductList());
	}

	@Test
	public void testGetTotalPrice() {
		assertEquals(3, cart.getTotalPrice(), 0.2);
	}

	@Test
	public void testGetId() {
		assertEquals((long) 1, cart.getId());
	}

}
