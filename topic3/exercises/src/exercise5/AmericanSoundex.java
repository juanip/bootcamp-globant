package exercise5;

import java.util.ArrayList;

public class AmericanSoundex {

	private final String value0Twice = "AEIOUY";
	private final String value0Single = "HW";
	private final String value1 = "BFPV";
	private final String value2 = "CGJKQSXZ";
	private final String value3 = "DT";
	private final String value4 = "L";
	private final String value5 = "MN";
	private final String value6 = "R";

	public char getFirstLetter(String word) {
		word = word.toUpperCase();

		return word.charAt(0);
	}

	public String getDigits(String word) {
		word = word.toUpperCase();
		ArrayList<Character> coded = new ArrayList<Character>();
		ArrayList<Character> filtered = new ArrayList<Character>();

		for (char c : word.toCharArray()) {
			if (value0Single.indexOf(c) != -1) {
				continue;
			}

			if (value0Twice.indexOf(c) != -1) {
				coded.add('0');
				continue;
			}

			if (value1.indexOf(c) != -1) {
				coded.add('1');
				continue;
			}

			if (value2.indexOf(c) != -1) {
				coded.add('2');
				continue;
			}

			if (value3.indexOf(c) != -1) {
				coded.add('3');
				continue;
			}

			if (value4.indexOf(c) != -1) {
				coded.add('4');
				continue;
			}

			if (value5.indexOf(c) != -1) {
				coded.add('5');
				continue;
			}

			if (value6.indexOf(c) != -1) {
				coded.add('6');
				continue;
			}
		}

		filtered.add(coded.get(0));

		for (int i = 1; i < coded.size(); i++) {
			// omit repetition
			if (coded.get(i) == coded.get(i - 1)) {
				continue;
			} else {
				if (coded.get(i) != '0') {
					filtered.add(coded.get(i));
				}
			}
		}

		if (filtered.size() < 4) {
			for (int i = 0; i < 4 - filtered.size(); i++) {
				filtered.add('0');
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 4; i++) {
			sb.append(filtered.get(i));
		}

		return sb.toString();
	}

	public String getSoundexCode(String word) {
		return getFirstLetter(word) + getDigits(word);
	}
}
