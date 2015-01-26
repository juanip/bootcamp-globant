package data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entities.Product;

public class ProductRepositoryTest {

	private ProductRepository productRepository = ProductRepository.getInstance();

	@Test
	public void testGetProduct() {
		assertEquals((long) 0, productRepository.getProduct(0).getId());
	}

	@Test
	public void testCreateProduct() {
		Product product = productRepository.createProduct("test", 666);
		assertEquals(product, productRepository.getProduct(product.getId()));
	}

}
