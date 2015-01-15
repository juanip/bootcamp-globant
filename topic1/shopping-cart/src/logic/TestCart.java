package logic;

import entities.Appliance;
import entities.Cart;
import entities.Fridge;
import entities.Offer;
import entities.TV;

public class TestCart {

	public static void main(String[] args) {
		Appliance tv1 = new TV(14, 5000, 42);
		Appliance tv2 = new TV(17, 2000, 21);
		Appliance fridge1 = new Fridge(54, 6500, 30);
		Appliance fridge2 = new Fridge(55, 7500, 40);

		Cart.setPaymentNumber(42);

		// Cash
		Cart cart1 = new Cart();

		cart1.addItem(tv1);
		cart1.addItem(tv2);
		cart1.addItem(fridge1);

		cart1.setPaymentMethod(new CashStrategy());

		cart1.closeCart();

		System.out.println("Payment Method: Cash");
		System.out.println(cart1.getInfoListItems());
		System.out.println("\nFinal price: $" + cart1.getFinalPrice());

		// Credit Card
		Cart cart2 = new Cart();

		cart2.addItem(tv1);
		cart2.addItem(tv2);
		cart2.addItem(fridge1);

		cart2.setPaymentMethod(new CreditCardStrategy("Juan Perez", "0044 3322 3344 5522"));

		cart2.closeCart();

		System.out.println("\nPayment Method: Credit Card");
		System.out.println(cart2.getInfoListItems());
		System.out.println("\nFinal price: $" + cart2.getFinalPrice());

		// Paypal
		Cart cart3 = new Cart();

		cart3.addItem(tv1);
		cart3.addItem(tv2);
		cart3.addItem(fridge1);

		cart3.setPaymentMethod(new PaypalStrategy("juan@perez.com", "12345"));

		cart3.closeCart();

		System.out.println("\nPayment Method: Paypal");
		System.out.println(cart3.getInfoListItems());
		System.out.println("\nFinal price: $" + cart3.getFinalPrice());

		// Offer

		Offer offer1 = new Offer(101, "Fridge & TV! 20% OFF!", 0.8);
		offer1.addOffer(tv2);
		offer1.addOffer(fridge2);

		System.out.println("\n");
		System.out.println(offer1);
		System.out.println("\nFinal price: $" + offer1.getListPrice());
	}
}
