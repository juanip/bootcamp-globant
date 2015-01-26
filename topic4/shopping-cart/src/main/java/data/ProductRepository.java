package data;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductRepository {
	private static ProductRepository instance;

	public static ProductRepository getInstance() {
		if (instance == null) {
			instance = new ProductRepository();
		}
		return instance;
	}

	private List<Product> products = new ArrayList<Product>();

	private ProductRepository() {
		createProduct("My product", 42);
		createProduct("Another product", 67);
		createProduct("A blue product", 73);
	}

	public Product getProduct(long id) {
		for (Product p : products) {
			if (p.getId() == id) {
				return p;
			}
		}

		throw new ProductNotFoundException(id);
	}

	public List<Product> getProducts() {
		return products;
	}

	public Product createProduct(String description, double price) {
		long id = 0;
		if (products.size() > 0) {
			id = products.get(products.size() - 1).getId() + 1;
		}
		Product product = new Product(id, description, price);
		products.add(product);

		return product;

	}

	class ProductNotFoundException extends RuntimeException {
		public ProductNotFoundException(long id) {
			super("Product " + id + " does not exist.");
		}
	}
}
