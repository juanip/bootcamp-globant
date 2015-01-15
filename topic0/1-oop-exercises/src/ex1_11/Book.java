package ex1_11;

import ex1_2.Author;

public class Book {

	private String name;
	private Author[] authors;
	private double price;
	private int qtyInStock;

	public Book(String name, Author[] author, double price) {
		this(name, author, price, 0);
	}

	public Book(String name, Author[] author, double price, int qtyInStock) {
		this.name = name;
		this.authors = author;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	public String getName() {
		return this.name;
	}

	public Author[] getAuthor() {
		return this.authors;
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

	public void printAuthors() {
		String desc = "";
		for (int i = 0; i < authors.length; i++) {
			desc += "\n" + authors[i];
		}
		System.out.println(desc);
	}

	@Override
	public String toString() {
		return "'" + getName() + "' by " + authors.length + " authors.";
	}
}