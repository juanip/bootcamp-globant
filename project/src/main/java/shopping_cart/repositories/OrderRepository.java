package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.Order;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {

}
