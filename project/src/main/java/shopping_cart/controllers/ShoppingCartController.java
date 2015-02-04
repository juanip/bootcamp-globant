package shopping_cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping_cart.entities.ShoppingCart;
import shopping_cart.services.IShoppingCartServices;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

	@Autowired
	private IShoppingCartServices shoppingCartServices;

	// get shopping cart
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ShoppingCart getShoppingCart(@RequestParam("token") String token) {
		return shoppingCartServices.getShoppingCart(token);
	}

	// add product to shopping cart
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public @ResponseBody ShoppingCart addProduct(@RequestParam("token") String token, @RequestParam("product_id") Long productId,
			@RequestParam("quantity") int quantity) {
		return shoppingCartServices.addProduct(token, productId, quantity);
	}
}