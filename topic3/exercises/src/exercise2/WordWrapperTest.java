package exercise2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class WordWrapperTest {

	private WordWrapper ww = new WordWrapper();

	@Test
	public void test30CharsString60Length() {
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("123456789012345678901234567890");
		assertEquals(rows, ww.getRows("123456789012345678901234567890", 60));
	}

	@Test
	public void testHelloWorld7Length() {
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("Hello");
		rows.add("World!");

		assertEquals(rows, ww.getRows("Hello World!", 7));
	}

	@Test
	public void testABCDEF3Length() {
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("a b");
		rows.add("c d");
		rows.add("e f");

		assertEquals(rows, ww.getRows("a b c d e f", 3));
	}

	@Test
	public void testExcelEnt() {
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("Excel");
		rows.add("ent");

		assertEquals(rows, ww.getRows("Excelent", 5));
	}
}
