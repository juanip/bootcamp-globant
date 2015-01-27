package entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreditCardTest {

	@Test
	public void test() {
		CreditCard card = new CreditCard("1234 5678 9012 3456", "Juan Perez");
		assertEquals("Juan Perez", card.getClient());
		assertEquals("1234 5678 9012 3456", card.getNumber());
	}

}
