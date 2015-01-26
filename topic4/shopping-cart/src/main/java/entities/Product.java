package entities;

public class Product {

	private long id;
	private String description;
	private double price;

	public Product() {
	}

	public Product(long id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
