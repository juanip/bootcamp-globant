package shopping_cart.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shopping_cart.entities.ItemLine;
import shopping_cart.entities.Product;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.repositories.ItemLineRepository;

@Component
public class ItemLineDAO {

	@Autowired
	private ItemLineRepository itemLineRepository;
	@Autowired
	private EntityManager em;

	public ItemLineDAO() {
	}

	public void createItemLine(Product product, int quantity, ShoppingCart shoppingCart) {
		this.itemLineRepository.save(new ItemLine(product, quantity, shoppingCart));
	}

	public ItemLine save(ItemLine itemLine) {
		return this.itemLineRepository.save(itemLine);
	}
}
