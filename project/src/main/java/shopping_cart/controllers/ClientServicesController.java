package shopping_cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping_cart.entities.Client;
import shopping_cart.entities.ClientSession;
import shopping_cart.exceptions.ClientNotAuthenticatedException;
import shopping_cart.services.ClientServices;

@RestController
@RequestMapping("/clients")
public class ClientServicesController {

	@Autowired
	private ClientServices clientServices;
	@Autowired
	private ClientSession clientSession;

	// Add client
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody Client addClient(@RequestParam("name") String name, @RequestParam("user") String user,
			@RequestParam("password") String password) {
		return this.clientServices.addClient(name, user, password);
	}

	// login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Client login(@RequestParam("user") String user, @RequestParam("password") String password) {
		Client cl = this.clientServices.login(user, password);
		clientSession.setClient(cl);
		return cl;
	}

	// Add credit card
	@RequestMapping(value = "/add-creditcard", method = RequestMethod.POST)
	public @ResponseBody Client addCreditCard(@RequestParam("number") String number, @RequestParam("security_code") String securityCode,
			@RequestParam("description") String description) {
		if (clientSession.getClient() == null) {
			throw new ClientNotAuthenticatedException();
		}

		return clientServices.addCreditCard(number, securityCode, description, clientSession.getClient());
	}
}
