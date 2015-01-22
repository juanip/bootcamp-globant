package exercise4;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

	private final String romanNumber;
	private final Map<Character, Integer> symbols = new HashMap<Character, Integer>();

	public RomanNumber(String romanNumber) {
		this.romanNumber = romanNumber;

		symbols.put('I', 1);
		symbols.put('V', 5);
		symbols.put('X', 10);
		symbols.put('L', 50);
		symbols.put('C', 100);
		symbols.put('D', 500);
		symbols.put('M', 1000);
	}

	public String getRomanNumber() {
		return this.romanNumber;
	}

	private int getValue(char c) {
		return Integer.parseInt(String.valueOf(c));
	}

	public int getIntNumber() {
		int position = romanNumber.length() - 1;

		char currentSymbol;
		char previousSymbol = romanNumber.charAt(position);

		int sum = getValue(previousSymbol);

		position--;

		for (; position > 0; position--) {
			currentSymbol = romanNumber.charAt(position);

			if (symbols.get(currentSymbol) >= symbols.get(previousSymbol)) {
				sum += symbols.get(currentSymbol);
			} else {
				sum -= symbols.get(currentSymbol);
			}

			previousSymbol = currentSymbol;
		}

		return sum;
	}
}
