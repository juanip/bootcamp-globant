package ex1_2;

public class Book {

	private String name;
	private Author author;
	private double price;
	private int qtyInStock;

	public Book(String name, Author author, double price) {
		this(name, author, price, 0);
	}

	public Book(String name, Author author, double price, int qtyInStock) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	public String getName() {
		return this.name;
	}

	public Author getAuthor() {
		return this.author;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQtyInStock() {
		return this.qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public String getAuthorName() {
		return getAuthor().getName();
	}

	public String getAuthorEmail() {
		return getAuthor().getEmail();
	}

	public char getAuthorGender() {
		return getAuthor().getGender();
	}

	@Override
	public String toString() {
		return "'" + getName() + "' by " + getAuthorName() + " (" + getAuthorGender() + ") at " + getAuthorEmail();
	}
}