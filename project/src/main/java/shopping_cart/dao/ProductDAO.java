package shopping_cart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Product;
import shopping_cart.repositories.ProductRepository;

@Component
@Scope(value = "singleton")
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProductsByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	// TO-DO throw not found exception
	public List<Product> getProducts(String description) {
		return productRepository.findByDescriptionLike(description);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(Long productId) {
		return productRepository.findOne(productId);
	}
}
