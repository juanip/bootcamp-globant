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
		boolean flag = false;
		Author[] authorsAux = new Author[5];
		int count = 0;

		for (int i = 0; i < numAuthors; i++) {
			if (this.authors[i].getName() == authorName) {
				flag = true;
				continue;
			} else {
				authorsAux[count] = this.authors[i];
				count++;
			}
		}

		if (flag) {
			this.authors = authorsAux;
			this.numAuthors--;
		}

		return flag;

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
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numAuthors; i++) {
			sb.append("\n" + authors[i]);
		}
		System.out.println(sb.toString());
	}

	@Override
	public String toString() {
		return "'" + getName() + "' by " + numAuthors + " authors.";
	}
}