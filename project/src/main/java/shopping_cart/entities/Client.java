package shopping_cart.entities;

import java.io.Serializable;
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
@Table(name = "clients")
public class Client implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "client_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "user")
	private String user;

	@Column(name = "password")
	private String password;

	@OneToMany(mappedBy = "client")
	private List<CreditCard> creditCards;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;

	public Client() {
	}

	public Client(String name, String user, String password, ShoppingCart shoppingCart) {
		this(name, user, password);
		this.shoppingCart = shoppingCart;
	}

	public Client(String name, String user, String password) {
		this.name = name;
		this.user = user;
		this.password = password;
	}

	@JsonIgnore
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getName() {
		return name;
	}

	public String getUser() {
		return user;
	}

	public Long getId() {
		return id;
	}

	public List<CreditCard> getCreditCards() {
		return this.creditCards;
	}

	public boolean isValidPassword(String password) {
		return (this.password.equals(password));
	}
}
