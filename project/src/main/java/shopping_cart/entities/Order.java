package shopping_cart.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "total")
	private double total;

	@OneToMany(mappedBy = "order")
	private List<ItemLine> itemLines;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "credit_card_id")
	private CreditCard creditCard;

	public Order() {
	}

	public Order(Date date, Client client, CreditCard creditCard) {
		this.date = date;
		this.client = client;
		this.creditCard = creditCard;
	}

	public Date getDate() {
		return date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ItemLine> getItemLines() {
		return itemLines;
	}

	public void setItemLines(List<ItemLine> itemLines) {
		this.itemLines = itemLines;
	}

	public Client getClient() {
		return client;
	}

	public Long getId() {
		return id;
	}

}
