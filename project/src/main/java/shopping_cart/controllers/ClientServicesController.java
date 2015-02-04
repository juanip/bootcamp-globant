package shopping_cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping_cart.entities.Client;
import shopping_cart.entities.CreditCard;
import shopping_cart.services.IClientServices;

@RestController
@RequestMapping("/clients")
public class ClientServicesController {

	@Autowired
	private IClientServices clientServices;

	// Add client
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Client addClient(@RequestBody Client client) {
		return this.clientServices.addClient(client);
	}

	// login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody Client client) {
		return this.clientServices.login(client.getUser(), client.getPassword()).toString();
	}

	// Add credit card
	@RequestMapping(value = "/{token}/add-creditcard", method = RequestMethod.POST)
	public @ResponseBody Client addCreditCard(@PathVariable("token") String token, @RequestBody CreditCard creditCard) {
		return clientServices.addCreditCard(token, creditCard);
	}
}
