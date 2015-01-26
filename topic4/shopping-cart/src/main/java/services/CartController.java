package services;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import data.CartRepository;
import data.ProductRepository;
import entities.Cart;
import entities.CreditCard;
import entities.Product;

@Controller
@RequestMapping("/cart")
public class CartController implements CartServices {

	private final CartRepository cartRepository = CartRepository.getInstance();
	private final ProductRepository productRepository = ProductRepository.getInstance();

	@Override
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Cart createCart() {
		return cartRepository.createCart();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable long id) {
		return cartRepository.getCart(id);
	}

	@Override
	@RequestMapping(value = "/{id}/products", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts(@PathVariable long id) {
		return cartRepository.getCart(id).getProductList();
	}

	@Override
	@RequestMapping(value = "/{idCart}/add", method = RequestMethod.POST)
	public @ResponseBody Cart addProduct(@PathVariable long idCart, @RequestBody Product product) {
		Cart cart = cartRepository.getCart(idCart);
		cart.addProduct(productRepository.getProduct(product.getId()));

		return cart;
	}

	@Override
	@RequestMapping(value = "/{id}/payment", method = RequestMethod.POST)
	public @ResponseBody Cart performPayment(@PathVariable long id, @RequestBody CreditCard creditCard) {
		Cart cart = cartRepository.getCart(id);
		cart.performPayment(creditCard);

		return cart;
	}

}
