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

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	protected Product() {
	}

	public Product(String description, double price, Category category) {
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public Long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

}
