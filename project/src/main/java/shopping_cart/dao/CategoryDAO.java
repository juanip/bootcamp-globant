package shopping_cart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Category;
import shopping_cart.repositories.CategoryRepository;

@Component
@Scope(value = "singleton")
public class CategoryDAO {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public Category createCategory(String category) {
		return categoryRepository.save(new Category(category));
	}
}
