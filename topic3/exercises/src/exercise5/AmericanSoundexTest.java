package exercise5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AmericanSoundexTest {

	AmericanSoundex as = new AmericanSoundex();

	@Test
	public void testGetFirstLetter() {
		assertEquals('R', as.getFirstLetter("Robert"));
		assertEquals('R', as.getFirstLetter("rupert"));
		assertEquals('A', as.getFirstLetter("Ashcraft"));
	}

	@Test
	public void testGetDigits() {
		assertEquals("163", as.getDigits("Robert"));
		assertEquals("163", as.getDigits("Rupert"));
		assertEquals("261", as.getDigits("Ashcraft"));
		assertEquals("530", as.getDigits("SANDY"));
	}

	@Test
	public void testGetSoundexCode() {
		assertEquals("R163", as.getSoundexCode("robert"));
		assertEquals("R163", as.getSoundexCode("rupert"));
		assertEquals("A261", as.getSoundexCode("AsHcraFt"));
		assertEquals("A261", as.getSoundexCode("Ashcroft"));
		assertEquals("T522", as.getSoundexCode("Tymczak"));
		assertEquals("P236", as.getSoundexCode("Pfister"));
		assertEquals("S530", as.getSoundexCode("sandy"));
	}
}
