package ex1_12;

import ex1_2.Author;

public class TestMyBook {
	public static void main(String[] args) {
		Book javaDummy = new Book("Java for Dummy", 19.99, 99);
		System.out.println(javaDummy); // toString()
		System.out.print("The authors are: ");
		javaDummy.printAuthors();

		javaDummy.addAuthor(new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm'));
		javaDummy.addAuthor(new Author("Paul Tan", "Paul@nowhere.com", 'm'));
		System.out.println(javaDummy); // toString()
		System.out.print("The authors are: ");
		javaDummy.printAuthors();

		javaDummy.removeAuthorByName("Paul Tan");
		System.out.print("The authors are: ");
		javaDummy.printAuthors();
	}
}
