package shopping_cart.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "shopping_cart_id")
	private Long id;

	@OneToMany(mappedBy = "shoppingCart")
	private List<ItemLine> itemLines;

	@Column(name = "total")
	private double total;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "shoppingCart")
	private Client client;

	public ShoppingCart() {
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

	private void setTotal(double total) {
		this.total = total;
	}

	public void updateTotal() {
		double total = 0;
		for (ItemLine il : itemLines) {
			total += il.getSubTotal();
		}

		setTotal(total);
	}

	@JsonIgnore
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
