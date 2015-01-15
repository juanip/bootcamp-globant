package ex1_12;

import ex1_2.Author;

public class Book {

	private String name;
	private Author[] authors = new Author[5];
	private int numAuthors = 0;
	private double price;
	private int qtyInStock;

	public Book(String name, double price) {
		this(name, price, 0);
	}

	public Book(String name, double price, int qtyInStock) {
		this.name = name;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}

	public void addAuthor(Author author) {
		this.authors[numAuthors] = author;
		this.numAuthors++;
	}

	public boolean removeAuthorByName(String authorName) {
		for (int i = 0; i < numAuthors; i++) {
			if (this.authors[i].getName() == authorName) {
				this.authors[i] = null;
				return true;
			}
		}

		return false;
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
		for (int i = 0; i < numAuthors; i++) {
			desc += "\n" + authors[i];
		}
		System.out.println(desc);
	}

	@Override
	public String toString() {
		return "'" + getName() + "' by " + numAuthors + " authors.";
	}
}