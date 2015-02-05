package shopping_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Client;
import shopping_cart.entities.CreditCard;
import shopping_cart.exceptions.CreditCardNotFoundException;
import shopping_cart.repositories.CreditCardRepository;

@Component
@Scope(value = "singleton")
public class CreditCardDAO {

	@Autowired
	private CreditCardRepository creditCardRepository;

	public CreditCard createCreditCard(String number, String securityCode, String description, Client client) {
		return creditCardRepository.save(new CreditCard(number, securityCode, description, client));
	}

	public CreditCard getCreditCard(String number) {
		CreditCard cc = creditCardRepository.findByNumber(number);

		if (cc == null) {
			throw new CreditCardNotFoundException();
		}

		return cc;
	}
}
