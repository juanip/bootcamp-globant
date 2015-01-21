package exercise1;

public class Check {

	private final String[] units = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private final String[] ten = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };
	private final String[] tens = { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

	private double amount;
	private String textIntegerAmount;
	private String textDecimalAmount;

	public Check(double amount) {
		setAmount(amount);
	}

	private void setAmount(double amount) {
		this.amount = amount;
		String textAmount = amount + "";
		String[] parts = textAmount.split("\\.");
		this.textDecimalAmount = parts[1];
		this.textIntegerAmount = parts[0];
	}

	public String getDecimalAmount() {
		return textDecimalAmount;
	}

	public String getIntegerAmount() {
		return textIntegerAmount;
	}

	private int getValue(int place) {
		return Integer.parseInt(String.valueOf(textIntegerAmount.charAt(place)));
	}

	public String getThousands() {
		if (textIntegerAmount.length() < 4) {
			return null;
		}

		int place = textIntegerAmount.length() - 4;
		int value = getValue(place);

		if (value == 0) {
			return "";
		}

		return units[value - 1] + " thousand ";
	}

	public String getHundreds() {
		if (textIntegerAmount.length() < 3) {
			return null;
		}

		int place = textIntegerAmount.length() - 3;
		int value = getValue(place);

		if (value == 0) {
			return "";
		}

		return units[value - 1] + " hundred ";
	}

	public String getTens() {
		if (textIntegerAmount.length() < 1) {
			return null;
		}

		int place = textIntegerAmount.length() - 1;
		int unitValue = getValue(place);

		if (textIntegerAmount.length() < 2) {
			if (unitValue == 0) {
				return "zero ";
			} else {
				return units[unitValue - 1] + " ";
			}
		}

		int tenValue = getValue(place - 1);

		if (tenValue == 0) {
			if (unitValue == 0) {
				return "zero ";
			} else {
				return units[unitValue - 1] + " ";
			}
		}

		if (tenValue == 1) {
			return ten[unitValue] + " ";
		}

		if (unitValue == 0) {
			return tens[tenValue - 2] + " ";
		}

		return tens[tenValue - 2] + "-" + units[unitValue - 1] + " ";
	}

	public String getDecimals() {
		if (textDecimalAmount.equals("")) {
			return "0/100" + " ";
		}
		return textDecimalAmount + "/100" + " ";
	}

	private String toText() {
		StringBuilder sb = new StringBuilder();

		if (textIntegerAmount.length() > 4) {
			throw new RuntimeException("The number is too big!");
		}

		if (textIntegerAmount.length() > 3) {
			sb.append(getThousands());
		}

		if (textIntegerAmount.length() > 2) {
			sb.append(getHundreds());
		}

		sb.append(getTens());
		sb.append("and ");
		sb.append(getDecimals());
		sb.append("dollars");

		return sb.toString();
	}

	@Override
	public String toString() {
		return toText();
	}
}