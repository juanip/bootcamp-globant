package entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private final long id;
	private List<Product> productList = new ArrayList<Product>();
	private double totalPrice = 0;
	private CreditCard creditCard;
	private boolean open = true;

	public Cart(long id) {
		this.id = id;
	}

	public List<Product> getProductList() {
		return this.productList;
	}

	public void addProduct(Product product) {
		this.productList.add(product);

		double totalPrice = 0;
		for (Product p : productList) {
			totalPrice += p.getPrice();
		}

		setTotalPrice(totalPrice);

	}

	private void setTotalPrice(double price) {
		this.totalPrice = price;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public long getId() {
		return this.id;
	}

	public void performPayment(CreditCard creditCard) {
		if (this.open) {
			this.creditCard = creditCard;
			this.open = false;
		} else {
			throw new CartAlreadyCloseException();
		}
	}

	public boolean getOpen() {
		return this.open;
	}

	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	class CartAlreadyCloseException extends RuntimeException {
		public CartAlreadyCloseException() {
			super("The payment has already been made");
		}
	}

}
