package logic;

import entities.Appliance;
import entities.Cart;
import entities.Fridge;
import entities.TV;

public class TestCart {

	public static void main(String[] args) {
		Appliance tv1 = new TV(14, 5000, 42);
		Appliance tv2 = new TV(17, 2000, 21);
		Appliance fridge1 = new Fridge(54, 6500, 30);

		// Cash
		Cart cart1 = new Cart();

		cart1.addAppliance(tv1);
		cart1.addAppliance(tv2);
		cart1.addAppliance(fridge1);

		cart1.setPaymentMethod(new CashStrategy());

		cart1.closeCart();

		System.out.println("Payment Method: Cash");
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(fridge1);
		System.out.println("Final price: $" + cart1.getFinalPrice());

		// Credit Card
		Cart cart2 = new Cart();

		cart2.addAppliance(tv1);
		cart2.addAppliance(tv2);
		cart2.addAppliance(fridge1);

		cart2.setPaymentMethod(new CreditCardStrategy("Juan Perez", "0044 3322 3344 5522"));

		cart2.closeCart();

		System.out.println("\nPayment Method: Credit Card");
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(fridge1);
		System.out.println("Final price: $" + cart2.getFinalPrice());

		// Paypal
		Cart cart3 = new Cart();

		cart3.addAppliance(tv1);
		cart3.addAppliance(tv2);
		cart3.addAppliance(fridge1);

		cart3.setPaymentMethod(new PaypalStrategy("juan@perez.com", "12345"));

		cart3.closeCart();

		System.out.println("\nPayment Method: Paypal");
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(fridge1);
		System.out.println("Final price: $" + cart3.getFinalPrice());

	}
}
