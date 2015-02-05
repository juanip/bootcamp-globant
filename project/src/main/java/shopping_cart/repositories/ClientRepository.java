package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Client findByUser(String user);

	public Client findByName(String name);
}
