package shopping_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.CategoryDAO;
import shopping_cart.dao.ProductDAO;
import shopping_cart.entities.Category;

@Component
public class ProductGenerator {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;

	@Transactional
	public void generate() {
		if (productDAO.getProducts().isEmpty()) {
			Category cat1 = categoryDAO.createCategory("food");
			Category cat2 = categoryDAO.createCategory("drink");
			Category cat3 = categoryDAO.createCategory("dessert");

			productDAO.createProduct("hamburger", 10, cat1);
			productDAO.createProduct("hotdog", 8, cat1);
			productDAO.createProduct("coke", 5, cat2);
			productDAO.createProduct("juice", 4, cat2);
			productDAO.createProduct("icecream", 7, cat3);
			productDAO.createProduct("cake", 6, cat3);
		}
	}
}
