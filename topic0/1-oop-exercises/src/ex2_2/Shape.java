package ex2_2;

public class Shape {

	private String color;
	private boolean filled;

	public Shape() {
		this("red", false);
	}

	public Shape(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A Shape with color of ");
		sb.append(this.color);
		sb.append(" and ");
		sb.append(this.filled ? "filled" : "not filled");

		return sb.toString();
	}

}
