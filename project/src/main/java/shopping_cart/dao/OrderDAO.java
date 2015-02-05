package shopping_cart.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import shopping_cart.entities.Client;
import shopping_cart.entities.CreditCard;
import shopping_cart.entities.Order;
import shopping_cart.repositories.OrderRepository;

@Component
@Scope(value = "singleton")
public class OrderDAO {

	@Autowired
	private OrderRepository orderRepository;

	public OrderDAO() {
	}

	public Order createOrder(Client client, CreditCard creditCard) {
		return this.orderRepository.save(new Order(new Date(), client, creditCard));
	}

	public Order save(Order order) {
		return this.orderRepository.save(order);
	}

	public Order getOrder(Order order) {
		return this.orderRepository.findOne(order.getId());
	}
}
