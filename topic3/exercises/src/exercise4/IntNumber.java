package exercise4;

public class IntNumber {

	private final int intNumber;

	public IntNumber(int intNumber) {
		if (intNumber > 4999) {
			throw new RuntimeException("The number is too big!");
		}
		if (intNumber < 1) {
			throw new RuntimeException("The number has to be greater than 0!");
		}
		this.intNumber = intNumber;
	}

	public int getIntNumber() {
		return intNumber;
	}

	public String getRomanThousands(int value) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < value; i++) {
			sb.append("M");
		}

		return sb.toString();
	}

	public String getRomanHundreds(int value) {
		StringBuilder sb = new StringBuilder();

		if (value == 9) {
			return "CM";
		}

		if (value > 4) {
			sb.append("D");
			for (int i = 0; i < value - 5; i++) {
				sb.append("C");
			}
		}

		if (value == 4) {
			sb.append("CD");
		}

		if (value < 4) {
			for (int i = 0; i < value; i++) {
				sb.append("C");
			}
		}

		return sb.toString();
	}

	public String getRomanTens(int value) {
		StringBuilder sb = new StringBuilder();

		if (value == 9) {
			return "XC";
		}

		if (value > 4) {
			sb.append("L");
			for (int i = 0; i < value - 5; i++) {
				sb.append("X");
			}
		}

		if (value == 4) {
			sb.append("XL");
		}

		if (value < 4) {
			for (int i = 0; i < value; i++) {
				sb.append("X");
			}
		}

		return sb.toString();
	}

	public String getRomanUnits(int value) {
		StringBuilder sb = new StringBuilder();

		if (value == 9) {
			return "IX";
		}

		if (value > 4) {
			sb.append("V");
			for (int i = 0; i < value - 5; i++) {
				sb.append("I");
			}
		}

		if (value == 4) {
			sb.append("IV");
		}

		if (value < 4) {
			for (int i = 0; i < value; i++) {
				sb.append("I");
			}
		}

		return sb.toString();
	}

	public String getRomanNumber() {
		char[] number = String.valueOf(intNumber).toCharArray();
		StringBuilder sb = new StringBuilder();
		int value = 0;
		int position = 0;

		if (number.length > 3) {
			value = Integer.parseInt(String.valueOf(number[position]));
			sb.append(getRomanThousands(value));
			position++;
		}

		if (number.length > 2) {
			value = Integer.parseInt(String.valueOf(number[position]));
			sb.append(getRomanHundreds(value));
			position++;
		}

		if (number.length > 1) {
			value = Integer.parseInt(String.valueOf(number[position]));
			sb.append(getRomanTens(value));
			position++;
		}

		value = Integer.parseInt(String.valueOf(number[position]));
		sb.append(getRomanUnits(value));

		return sb.toString();
	}
}
