package ex3_2;

public class Cylinder {
	private Circle base; // Base circle, an instance of Circle class
	private double height;

	// Constructor with default color, radius and height
	public Cylinder() {
		this(1.0);
	}

	public Cylinder(double height) {
		this.base = new Circle();
		this.height = height;
	}

	// Constructor with default color, but given radius, height
	public Cylinder(double radius, double height) {
		this.base = new Circle(radius);
		this.height = height;
	}

	// A public method for retrieving the height
	public double getHeight() {
		return height;
	}

	// A public method for computing the volume of cylinder
	// use superclass method getArea() to get the base area
	public double getVolume() {
		return base.getArea() * height;
	}

	public double getArea() {
		return 2 * Math.PI * base.getRadius() * getHeight() + 2 * base.getArea();
	}

	@Override
	public String toString() { // in Cylinder class
		return "Cylinder: base " + base + " height=" + height;
	}

	public double getRadius() {
		return base.getRadius();
	}
}
