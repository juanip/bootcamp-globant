package shopping_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Client;
import shopping_cart.entities.ItemLine;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.repositories.ShoppingCartRepository;

@Component
@Scope(value = "singleton")
public class ShoppingCartDAO {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private ClientDAO clientDAO;

	public ShoppingCart getShoppingCart(Client client) {
		ShoppingCart sc = shoppingCartRepository.findByClient(client.getUser());
		System.out.println("\n\n2 " + sc);
		if (sc == null) {
			sc = shoppingCartRepository.save(new ShoppingCart(client));
			System.out.println("\n\n3 " + sc);
		}
		return sc;
	}

	public ShoppingCart updateTotal(ShoppingCart sc) {
		double total = 0;
		for (ItemLine il : sc.getItemLines()) {
			total += il.getSubTotal();
		}

		sc.setTotal(total);

		return shoppingCartRepository.save(sc);

	}
}
