package shopping_cart.entities;

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
@Table(name = "item_lines")
public class ItemLine {

	@Id
	@GeneratedValue
	@Column(name = "item_line_id")
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;

	public ItemLine() {
	}

	public ItemLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public ItemLine(Product product, int quantity, ShoppingCart shoppingCart) {
		this(product, quantity);
		this.shoppingCart = shoppingCart;
	}

	public ItemLine(Product product, int quantity, Order order) {
		this(product, quantity);
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@JsonIgnore
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Long getId() {
		return id;
	}

	public double getSubTotal() {
		return product.getPrice() * quantity;
	}
}