package services;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import data.ProductRepository;
import entities.Product;

@Controller
@RequestMapping("/products")
public class ProductsController implements ProductsServices {

	private final ProductRepository productRepository = ProductRepository.getInstance();

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		return productRepository.getProducts();
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable long id) {
		return productRepository.getProduct(id);
	}

	@Override
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Product addProduct(@RequestBody Product product) {
		return productRepository.createProduct(product.getDescription(), product.getPrice());
	}

}