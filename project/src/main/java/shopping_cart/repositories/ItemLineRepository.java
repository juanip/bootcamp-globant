package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.ItemLine;

@Repository("itemLineRepository")
public interface ItemLineRepository extends JpaRepository<ItemLine, Long> {

}
