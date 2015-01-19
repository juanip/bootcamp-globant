package ex3_2;

public class Circle { // save as "Circle.java"
	// private instance variable, not accessible from outside this class
	private double radius;
	private String color;

	// 1st constructor, which sets both radius and color to default
	public Circle() {
		this(1.0, "red");
	}

	// 2nd constructor with given radius, but color default
	public Circle(double radius) {
		this(radius, "red");
	}

	// Construtor to construct a new instance of Circle with the given radius
	// and color
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	// A public method for retrieving the radius
	public double getRadius() {
		return radius;
	}

	// A public method for computing the area of circle
	public double getArea() {
		return radius * radius * Math.PI;
	}

	// Setter for instance variable radius
	public void setRadius(double radius) {
		this.radius = radius;
	}

	// Setter for instance variable color
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Circle: radius=" + radius + " color=" + color;
	}
}