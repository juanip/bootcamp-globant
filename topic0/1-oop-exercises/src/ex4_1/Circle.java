package ex4_1;

public class Circle extends Shape {

	protected double radius;

	public Circle() {
		this(1.0);
	}

	public Circle(double radius) {
		super();
		setRadius(radius);
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		setRadius(radius);
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A circle of radius=" + getRadius() + ", color=" + getColor() + " and ");
		sb.append(isFilled() ? "filled" : "not filled");

		return sb.toString();
	}

	@Override
	public double getArea() {
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}

}
