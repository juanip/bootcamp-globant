package logic;

import entities.Appliance;
import entities.Cart;
import entities.Fridge;
import entities.Offer;
import entities.TV;

public class AppTest {

	public static void main(String[] args) {
		Mailist mailist = Mailist.getMailist();

		DAOAppliance appliances = DAOAppliance.getDAOAppliance();
		DAOOffer offers = DAOOffer.getDAOOffers();

		appliances.addObserver(mailist);
		offers.addObserver(mailist);

		// stock
		Appliance tv1 = new TV(1, 5000, 42, mailist);
		Appliance tv2 = new TV(2, 2000, 21, mailist);
		Appliance fridge1 = new Fridge(3, 6500, 30, mailist);
		Appliance fridge2 = new Fridge(4, 7500, 40, mailist);

		appliances.addAppliance(tv1);
		appliances.addAppliance(tv2);
		appliances.addAppliance(fridge1);
		appliances.addAppliance(fridge2);

		// make a offer
		Offer offer1 = new Offer(42, "Fride & TV: 30% OFF!", mailist);
		offer1.addOffer(tv2);
		offer1.addOffer(fridge1);

		offers.addOffer(offer1);

		// change a price
		appliances.getAppliance(2).setListPrice(3000);

		// new shopping cart
		PaypalStrategy payment = new PaypalStrategy("juan@perez", "1234");
		Cart cart = new Cart(payment, mailist);

		cart.addItem(tv1);
		cart.addItem(fridge1);

		cart.closeCart();

		System.out.println(cart);

		// mail notifications
		System.out.println("\n\n" + mailist);
	}

}
