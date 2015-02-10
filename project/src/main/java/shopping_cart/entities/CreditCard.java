package shopping_cart.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "credit_cards")
public class CreditCard implements Serializable {

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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id")
	private Client client;

	protected CreditCard() {
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

	public String getSecurityCode() {
		return securityCode;
	}

	public String getDescription() {
		return description;
	}

	@JsonIgnore
	public Client getClient() {
		return client;
	}

	public Long getId() {
		return id;
	}

}
