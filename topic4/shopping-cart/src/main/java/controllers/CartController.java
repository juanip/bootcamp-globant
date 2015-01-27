package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import services.CartServices;
import services.ICartServices;
import entities.Cart;
import entities.CreditCard;
import entities.Product;

@Controller
@RequestMapping("/cart")
public class CartController implements ICartServices {

	private final ICartServices cartServices = new CartServices();

	@Override
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Cart createCart() {
		return cartServices.createCart();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable long id) {
		return cartServices.getCart(id);
	}

	@Override
	@RequestMapping(value = "/{id}/products", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(@PathVariable long id) {
		return cartServices.getProducts(id);
	}

	@Override
	@RequestMapping(value = "/{id}/add", method = RequestMethod.POST)
	public @ResponseBody Cart addProduct(@PathVariable long id, @RequestBody Product product) {
		return cartServices.addProduct(id, product);
	}

	@Override
	@RequestMapping(value = "/{id}/payment", method = RequestMethod.POST)
	public @ResponseBody Cart performPayment(@PathVariable long id, @RequestBody CreditCard creditCard) {
		return cartServices.performPayment(id, creditCard);
	}

}
