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
@Table(name = "item_lines")
public class ItemLine implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "item_line_id")
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "subtotal")
	private double subTotal;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;

	public ItemLine() {
	}

	public ItemLine(Product product, int quantity, ShoppingCart shoppingCart) {
		this.product = product;
		this.quantity = quantity;
		this.subTotal = product.getPrice() * quantity;
		this.shoppingCart = shoppingCart;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
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

	public Long getId() {
		return id;
	}

	public double getSubTotal() {
		return this.subTotal;
	}
}