package shopping_cart.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

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

	// @OneToMany(mappedBy = "client")
	// private List<CreditCard> creditCards;

	// @OneToMany(mappedBy = "client")
	// private List<Order> orders;

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

	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

}
