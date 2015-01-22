package exercise4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestIntNumber {

	private IntNumber intNumber1 = new IntNumber(1);

	@Test
	public void testGetIntNumber() {
		assertEquals(1, intNumber1.getIntNumber());
	}

	@Test
	public void testGetRomanThousands() {
		assertEquals("M", intNumber1.getRomanThousands(1));
		assertEquals("MM", intNumber1.getRomanThousands(2));
		assertEquals("MMM", intNumber1.getRomanThousands(3));
		assertEquals("MMMM", intNumber1.getRomanThousands(4));
	}

	@Test
	public void testGetRomanHundreds() {
		assertEquals("C", intNumber1.getRomanHundreds(1));
		assertEquals("CC", intNumber1.getRomanHundreds(2));
		assertEquals("CCC", intNumber1.getRomanHundreds(3));
		assertEquals("CD", intNumber1.getRomanHundreds(4));
		assertEquals("D", intNumber1.getRomanHundreds(5));
		assertEquals("DC", intNumber1.getRomanHundreds(6));
		assertEquals("DCC", intNumber1.getRomanHundreds(7));
		assertEquals("DCCC", intNumber1.getRomanHundreds(8));
		assertEquals("CM", intNumber1.getRomanHundreds(9));
		assertEquals("", intNumber1.getRomanHundreds(0));
	}

	@Test
	public void testGetRomanTens() {
		assertEquals("X", intNumber1.getRomanTens(1));
		assertEquals("XX", intNumber1.getRomanTens(2));
		assertEquals("XXX", intNumber1.getRomanTens(3));
		assertEquals("XL", intNumber1.getRomanTens(4));
		assertEquals("L", intNumber1.getRomanTens(5));
		assertEquals("LX", intNumber1.getRomanTens(6));
		assertEquals("LXX", intNumber1.getRomanTens(7));
		assertEquals("LXXX", intNumber1.getRomanTens(8));
		assertEquals("XC", intNumber1.getRomanTens(9));
		assertEquals("", intNumber1.getRomanTens(0));
	}

	@Test
	public void testGetRomanUnits() {
		assertEquals("I", intNumber1.getRomanUnits(1));
		assertEquals("II", intNumber1.getRomanUnits(2));
		assertEquals("III", intNumber1.getRomanUnits(3));
		assertEquals("IV", intNumber1.getRomanUnits(4));
		assertEquals("V", intNumber1.getRomanUnits(5));
		assertEquals("VI", intNumber1.getRomanUnits(6));
		assertEquals("VII", intNumber1.getRomanUnits(7));
		assertEquals("VIII", intNumber1.getRomanUnits(8));
		assertEquals("IX", intNumber1.getRomanUnits(9));
		assertEquals("", intNumber1.getRomanUnits(0));
	}

	@Test
	public void testGetRomanNumber() {
		IntNumber intNumber2 = new IntNumber(1954);
		IntNumber intNumber3 = new IntNumber(2014);
		IntNumber intNumber4 = new IntNumber(1990);
		IntNumber intNumber5 = new IntNumber(3287);
		IntNumber intNumber6 = new IntNumber(154);
		IntNumber intNumber7 = new IntNumber(9);
		IntNumber intNumber8 = new IntNumber(4999);

		assertEquals("I", intNumber1.getRomanNumber());
		assertEquals("MCMLIV", intNumber2.getRomanNumber());
		assertEquals("MMXIV", intNumber3.getRomanNumber());
		assertEquals("MCMXC", intNumber4.getRomanNumber());
		assertEquals("MMMCCLXXXVII", intNumber5.getRomanNumber());
		assertEquals("CLIV", intNumber6.getRomanNumber());
		assertEquals("IX", intNumber7.getRomanNumber());
		assertEquals("MMMMCMXCIX", intNumber8.getRomanNumber());

	}
}
