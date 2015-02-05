package shopping_cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping_cart.entities.ClientSession;
import shopping_cart.entities.Order;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.services.IShoppingCartServices;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

	@Autowired
	private IShoppingCartServices shoppingCartServices;
	@Autowired
	private ClientSession clientSession;

	// get shopping cart
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ShoppingCart getShoppingCart() {
		return shoppingCartServices.getShoppingCart(clientSession.getClient());
	}

	// add product to shopping cart
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public @ResponseBody ShoppingCart addProduct(@RequestParam("product_id") Long productId, @RequestParam("quantity") int quantity) {
		return shoppingCartServices.addProduct(productId, quantity, clientSession.getClient());
	}

	// buy products
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public @ResponseBody Order buyProducts(@RequestParam("credit_card_number") String number) {
		return shoppingCartServices.buyProducts(clientSession.getClient(), number);
	}
}