package ex1_10;

public class MyDate {

	private int year;
	private int month;
	private int day;

	private static String[] strMonths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private static String[] strDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	private static int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static int[] normalYearTable = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
	private static int[] leapYearTable = { 6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

	public static boolean isLeapYear(int year) {
		boolean mod4 = year % 4 == 0;
		boolean mod100 = year % 100 == 0;
		boolean mod400 = year % 400 == 0;

		if (mod4 && !mod100) {
			return true;
		}

		if (mod100 && mod400) {
			return true;
		}

		return false;
	}

	public static boolean isValidDate(int year, int month, int day) {
		boolean fyear = year > 0 && year < 10000;
		boolean fmonth = month > 0 && month < 13;

		if (fyear && fmonth) {
			if (month != 2 && day > 0 && day <= daysInMonths[month - 1]) {
				return true;
			} else if (month == 2) {
				if (isLeapYear(year)) {
					return (day > 0 && day <= 29);
				} else {
					return (day > 0 && day <= 28);
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static int getDayOfWeek(int year, int month, int day) {
		int centuryTable;

		if (year % 400 < 100) {
			centuryTable = 6;
		} else if (year % 400 < 200) {
			centuryTable = 4;
		} else if (year % 400 < 300) {
			centuryTable = 2;
		} else {
			centuryTable = 0;
		}

		int lastTwoDigit = year % 100;
		int lastTwoDigitDivideByFour = (int) (lastTwoDigit / 4);
		int monthTable = isLeapYear(year) ? leapYearTable[month - 1] : normalYearTable[month - 1];

		return (centuryTable + lastTwoDigit + lastTwoDigitDivideByFour + monthTable + day) % 7;
	}

	public MyDate(int year, int month, int day) {
		setDate(year, month, day);
	}

	public void setDate(int year, int month, int day) {
		if (isValidDate(year, month, day)) {
			this.year = year;
			this.month = month;
			this.day = day;
		} else {
			throw new IllegalArgumentException("Invalid year, month, or day!");
		}
	}

	public void setYear(int year) {
		if (year > 0 && year < 10000) {
			this.year = year;
		} else {
			throw new IllegalArgumentException("Invalid year!");
		}
	}

	public void setMonth(int month) {
		if (month > 0 && month < 13) {
			this.month = month;
		} else {
			throw new IllegalArgumentException("Invalid month!");
		}
	}

	public void setDay(int day) {
		if (isValidDate(this.year, this.month, day)) {
			this.day = day;
		} else {
			throw new IllegalArgumentException("Invalid day!");
		}
	}

	public int getYear() {
		return this.year;
	}

	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	@Override
	public String toString() {
		return strDays[getDayOfWeek(year, month, day)] + " " + getDay() + " " + strMonths[month - 1] + " " + getYear();
	}

	public MyDate nextDay() {
		if (isLeapYear(year) && month == 2 && day == 28) {
			day = 29;
		} else if (day < daysInMonths[month - 1]) {
			day++;
		} else {
			day = 1;
			nextMonth();
		}

		return this;
	}

	public MyDate nextMonth() {
		if (month < 12) {
			month++;
		} else {
			month = 1;
			nextYear();
		}

		return this;
	}

	public MyDate nextYear() {
		if (year < 9999) {
			year++;
		} else {
			throw new IllegalStateException("Year out of range!");
		}

		return this;
	}

	public MyDate previousDay() {
		if (isLeapYear(year) && month == 3 && day == 1) {
			day = 29;
			previousMonth();
		} else if (day > 1) {
			day--;
		} else {
			if (month == 1) {
				day = 31;
				previousMonth();
			} else {
				day = daysInMonths[month - 2];
				previousMonth();
			}
		}

		return this;
	}

	public MyDate previousMonth() {
		if (month > 1) {
			month--;
		} else {
			month = 12;
			previousYear();
		}

		return this;
	}

	public MyDate previousYear() {
		if (year > 1) {
			year--;
		} else {
			throw new IllegalStateException("Year out of range!");
		}

		return this;
	}

}