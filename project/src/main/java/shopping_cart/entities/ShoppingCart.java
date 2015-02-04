package shopping_cart.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {

	@Id
	@GeneratedValue
	@Column(name = "shopping_cart_id")
	private Long id;

	@OneToMany(mappedBy = "shoppingCart")
	private List<ItemLine> itemLines;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "shoppingCart")
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(name = "total")
	private double total;

	public ShoppingCart() {
	}

	public ShoppingCart(Client client) {
		this.client = client;
	}

	@JsonIgnore
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ItemLine> getItemLines() {
		return itemLines;
	}

	public Long getId() {
		return id;
	}

	@JsonIgnore
	public boolean isEmpty() {
		return this.itemLines.isEmpty();
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
