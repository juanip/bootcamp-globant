package ex2_2;

public class Circle extends Shape {

	private double radius;

	public Circle() {
		this(1.0);
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A Circle with radius=");
		sb.append(getRadius());
		sb.append(", which is a subclass of ");
		sb.append(super.toString());

		return sb.toString();
	}
}
