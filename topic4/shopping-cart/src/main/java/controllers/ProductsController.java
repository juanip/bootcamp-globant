package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import services.IProductsServices;
import services.ProductsServices;
import entities.Product;

@Controller
@RequestMapping("/products")
public class ProductsController {

	private final IProductsServices productsServices = new ProductsServices();

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		return productsServices.getProducts();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable long id) {
		return productsServices.getProduct(id);
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Product addProduct(@RequestBody Product product) {
		return productsServices.addProduct(product);
	}
}