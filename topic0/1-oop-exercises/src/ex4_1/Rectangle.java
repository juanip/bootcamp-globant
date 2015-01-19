package ex4_1;

public class Rectangle extends Shape {

	protected double width;
	protected double length;

	public Rectangle() {
		this(1.0, 1.0);
	}

	public Rectangle(double width, double length) {
		super();
		setLength(length);
		setWidth(width);
	}

	public Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		setLength(length);
		setWidth(width);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A rectangle of width=" + getWidth());
		sb.append(", length=" + getLength() + ", color=" + getColor() + " and ");
		sb.append(isFilled() ? "filled" : "not filled");

		return sb.toString();
	}

	@Override
	public double getArea() {
		return getLength() * getWidth();
	}

	@Override
	public double getPerimeter() {
		return getLength() * 2 + getWidth() * 2;
	}

}
