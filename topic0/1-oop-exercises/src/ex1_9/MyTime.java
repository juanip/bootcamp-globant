package ex1_9;

public class MyTime {

	private int hour;
	private int minute;
	private int second;

	public MyTime(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}

	public void setTime(int hour, int minute, int second) {
		this.setHour(hour);
		this.setMinute(minute);
		this.setSecond(second);
	}

	public void setHour(int hour) {
		if (hour < 24 && hour > 0) {
			this.hour = hour;
		} else {
			throw new IllegalArgumentException("Invalid hour!");
		}
	}

	public void setMinute(int minute) {
		if (minute < 60 && minute > 0) {
			this.minute = minute;
		} else {
			throw new IllegalArgumentException("Invalid minute!");
		}
	}

	public void setSecond(int second) {
		if (second < 60 && second > 0) {
			this.second = second;
		} else {
			throw new IllegalArgumentException("Invalid second!");
		}
	}

	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public int getSecond() {
		return this.second;
	}

	@Override
	public String toString() {
		String desc = "";
		desc += hour < 10 ? "0" + hour : hour;
		desc += ":";
		desc += minute < 10 ? "0" + minute : minute;
		desc += ":";
		desc += second < 10 ? "0" + second : second;

		return desc;
	}

	public MyTime nextSecond() {
		if (second < 59) {
			second++;
		} else {
			second = 0;
			nextMinute();
		}

		return this;
	}

	public MyTime nextMinute() {
		if (minute < 59) {
			minute++;
		} else {
			minute = 0;
			nextHour();
		}

		return this;
	}

	public MyTime nextHour() {
		if (hour < 23) {
			hour++;
		} else {
			hour = 0;
		}

		return this;
	}

	public MyTime previousSecond() {
		if (second > 0) {
			second--;
		} else {
			second = 59;
			previousMinute();
		}

		return this;
	}

	public MyTime previousMinute() {
		if (minute > 0) {
			minute--;
		} else {
			minute = 59;
			previousHour();
		}

		return this;
	}

	public MyTime previousHour() {
		if (hour > 0) {
			hour--;
		} else {
			hour = 23;
		}

		return this;
	}
}