package shopping_cart.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private Long id;

	@Column(name = "description")
	private String description;

	protected Category() {
	}

	public Category(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}
}
