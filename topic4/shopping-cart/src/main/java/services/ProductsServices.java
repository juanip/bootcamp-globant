package services;

import java.util.List;

import data.ProductRepository;
import entities.Product;

public class ProductsServices implements IProductsServices {

	private final ProductRepository productRepository = ProductRepository.getInstance();

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

	@Override
	public Product getProduct(long id) {
		return productRepository.getProduct(id);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.createProduct(product.getDescription(), product.getPrice());
	}

}
