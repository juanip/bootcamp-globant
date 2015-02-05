package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.CreditCard;

@Repository("creditCardRepository")
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

	CreditCard findByNumber(String number);

}
