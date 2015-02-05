package shopping_cart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String getInfo() {
		StringBuilder sb = new StringBuilder();

		String url = "{\"url\":\"";
		String description = "\",\"description\":\"";
		String end = "\"},";

		sb.append("{\"urls\":[");

		sb.append(url);
		sb.append("/");
		sb.append(description);
		sb.append("list of available urls");
		sb.append(end);

		sb.append(url);
		sb.append("/clients/new");
		sb.append(description);
		sb.append("post name, user and password");
		sb.append(end);

		sb.append(url);
		sb.append("/clients/login");
		sb.append(description);
		sb.append("post user and password");
		sb.append(end);

		sb.append(url);
		sb.append("/clients/add-creditcard");
		sb.append(description);
		sb.append("post number, security_code and description; returns client");
		sb.append(end);

		sb.append(url);
		sb.append("/products");
		sb.append(description);
		sb.append("returns all the products");
		sb.append(end);

		sb.append(url);
		sb.append("/products/search");
		sb.append(description);
		sb.append("post query with the product description, returns a list of products");
		sb.append(end);

		sb.append(url);
		sb.append("/products/categories");
		sb.append(description);
		sb.append("returns all the categories");
		sb.append(end);

		sb.append(url);
		sb.append("/products/categories/:category");
		sb.append(description);
		sb.append("returns all the products within :category");
		sb.append(end);

		sb.append(url);
		sb.append("/shopping-cart");
		sb.append(description);
		sb.append("returns the shopping cart");
		sb.append(end);

		sb.append(url);
		sb.append("/shopping-cart/add-product");
		sb.append(description);
		sb.append("post product_id and quantity, returns the shopping cart");
		sb.append(end);

		sb.append(url);
		sb.append("/shopping-cart/buy");
		sb.append(description);
		sb.append("post credit_card_number, returns order");
		// sb.append(end);

		// sb.append(url);
		// sb.append("/");
		// sb.append(description);
		// sb.append("");
		// sb.append(end);

		sb.append("\"}");
		sb.append("}]}");

		return sb.toString();
	}
}