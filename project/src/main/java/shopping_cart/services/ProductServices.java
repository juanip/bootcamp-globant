package shopping_cart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import shopping_cart.dao.CategoryDAO;
import shopping_cart.dao.ProductDAO;
import shopping_cart.entities.Category;
import shopping_cart.entities.Product;

@Service
@Configurable
public class ProductServices implements IProductServices {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Product> getProductsByDescription(String description) {
		return productDAO.getProducts(description);
	}

	// TO-DO throw category not found exception
	@Override
	public List<Product> getProductsByCategory(String category) {
		return productDAO.getProductsByCategory(category);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDAO.getCategories();
	}

	@Override
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

}
