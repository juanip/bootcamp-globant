package exercise4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRomanNumber {

	private RomanNumber romanNumber1 = new RomanNumber("I");

	@Test
	public void testGetRomanNumber() {
		assertEquals("I", romanNumber1.getRomanNumber());
	}

	public void testGetIntNumber() {
		RomanNumber romanNumber2 = new RomanNumber("MCMLIV");
		RomanNumber romanNumber3 = new RomanNumber("MMXIV");
		RomanNumber romanNumber4 = new RomanNumber("MCMXC");
		RomanNumber romanNumber5 = new RomanNumber("MMMCCLXXXVII");
		RomanNumber romanNumber6 = new RomanNumber("CLIV");
		RomanNumber romanNumber7 = new RomanNumber("IX");
		RomanNumber romanNumber8 = new RomanNumber("MMMMCMXCIX");

		assertEquals(1, romanNumber1.getIntNumber());
		assertEquals(1954, romanNumber2.getIntNumber());
		assertEquals(2014, romanNumber3.getIntNumber());
		assertEquals(1990, romanNumber4.getIntNumber());
		assertEquals(3287, romanNumber5.getIntNumber());
		assertEquals(154, romanNumber6.getIntNumber());
		assertEquals(9, romanNumber7.getIntNumber());
		assertEquals(4999, romanNumber8.getIntNumber());
	}
}
