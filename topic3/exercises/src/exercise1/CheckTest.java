package exercise1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckTest {

	Check check1 = new Check(0);
	Check check2 = new Check(1.03);
	Check check3 = new Check(9.18);
	Check check4 = new Check(110.0);
	Check check5 = new Check(1019.43);
	Check check6 = new Check(1111.78);
	Check check7 = new Check(3948.56);
	Check check8 = new Check(1031.62);
	Check check9 = new Check(9999.99);
	Check check10 = new Check(1234.56);
	Check check11 = new Check(2430.4);
	Check check12 = new Check(101);
	Check check13 = new Check(.32);

	@Test
	public void testGetAmount() {
		// 0
		assertEquals("0", check1.getIntegerAmount());
		assertEquals("0", check1.getDecimalAmount());

		// 1.03
		assertEquals("1", check2.getIntegerAmount());
		assertEquals("03", check2.getDecimalAmount());

		// 1234.56
		assertEquals("1234", check10.getIntegerAmount());
		assertEquals("56", check10.getDecimalAmount());

	}

	@Test
	public void testGetThousand() {
		// 1019.43
		assertEquals("one thousand ", check5.getThousands());
		// 2430.4
		assertEquals("two thousand ", check11.getThousands());
		// 999999.99
		assertEquals("nine thousand ", check9.getThousands());
		// 1.03
		assertEquals(null, check2.getThousands());
	}

	@Test
	public void testGetHundreds() {
		// 110.0
		assertEquals("one hundred ", check4.getHundreds());
		// 1019.43
		assertEquals("", check5.getHundreds());
		// 3948.56
		assertEquals("nine hundred ", check7.getHundreds());
		// 9.18
		assertEquals(null, check3.getHundreds());
	}

	@Test
	public void testGetTens() {
		// 110.0
		assertEquals("ten ", check4.getTens());
		// 2430.4
		assertEquals("thirty ", check11.getTens());
		// 999999.99
		assertEquals("ninety-nine ", check9.getTens());
		// 1.03
		assertEquals("one ", check2.getTens());
		// 3948.56
		assertEquals("forty-eight ", check7.getTens());
		// 1019.43
		assertEquals("nineteen ", check5.getTens());
		// 101
		assertEquals("one ", check12.getTens());
		// 0
		assertEquals("zero ", check1.getTens());
	}

	@Test
	public void testGetDecimals() {
		// .32
		assertEquals("32/100 ", check13.getDecimals());
		// 1111.78
		assertEquals("78/100 ", check6.getDecimals());
		// 110.0
		assertEquals("0/100 ", check4.getDecimals());
		// 101
		assertEquals("0/100 ", check12.getDecimals());
	}

	@Test
	public void testToString() {
		assertEquals("zero and 0/100 dollars", check1.toString());
		assertEquals("one and 03/100 dollars", check2.toString());
		assertEquals("nine and 18/100 dollars", check3.toString());
		assertEquals("one hundred ten and 0/100 dollars", check4.toString());
		assertEquals("one thousand nineteen and 43/100 dollars", check5.toString());
		assertEquals("one thousand one hundred eleven and 78/100 dollars", check6.toString());
		assertEquals("three thousand nine hundred forty-eight and 56/100 dollars", check7.toString());
		assertEquals("one thousand thirty-one and 62/100 dollars", check8.toString());
		assertEquals("nine thousand nine hundred ninety-nine and 99/100 dollars", check9.toString());
		assertEquals("one thousand two hundred thirty-four and 56/100 dollars", check10.toString());
		assertEquals("two thousand four hundred thirty and 4/100 dollars", check11.toString());
		assertEquals("one hundred one and 0/100 dollars", check12.toString());
		assertEquals("zero and 32/100 dollars", check13.toString());
	}
}