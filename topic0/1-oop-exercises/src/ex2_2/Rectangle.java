package ex2_2;

public class Rectangle extends Shape {

	private double width;
	private double lenght;

	public Rectangle() {
		this(1.0, 1.0);
	}

	public Rectangle(double width, double lenght) {
		super();
		this.lenght = lenght;
		this.width = width;
	}

	public Rectangle(double width, double lenght, String color, boolean filled) {
		super(color, filled);
		this.lenght = lenght;
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLenght() {
		return lenght;
	}

	public void setLenght(double lenght) {
		this.lenght = lenght;
	}

	public double getPerimeter() {
		return getWidth() * 2 + getLenght() * 2;
	}

	public double getArea() {
		return getWidth() * getLenght();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A Rectangle with width=");
		sb.append(getWidth());
		sb.append(" and length=");
		sb.append(getLenght());
		sb.append(", which is a subclass of ");
		sb.append(super.toString());

		return sb.toString();
	}
}
