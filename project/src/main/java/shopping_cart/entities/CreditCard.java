package shopping_cart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard {

	@Id
	@GeneratedValue
	@Column(name = "credit_card_id")
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "security_code")
	private String securityCode;

	@Column(name = "description")
	private String description;

	// @OneToMany(mappedBy = "creditCard")
	// private List<Order> orders;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;

	public CreditCard() {
	}

	public CreditCard(String number, String securityCode, String description, Client client) {
		this.number = number;
		this.securityCode = securityCode;
		this.description = description;
		this.client = client;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

}
