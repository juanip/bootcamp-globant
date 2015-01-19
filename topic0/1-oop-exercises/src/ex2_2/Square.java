package ex2_2;

public class Square extends Rectangle {

	public Square() {
		super();
	}

	public Square(double side) {
		super(side, side);
	}

	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}

	public double getSide() {
		return super.getLenght();
	}

	public void setSide(double side) {
		super.setLenght(side);
		super.setWidth(side);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A Square with side=");
		sb.append(getSide());
		sb.append(", which is a subclass of ");
		sb.append(super.toString());

		return sb.toString();
	}

	@Override
	public void setLenght(double lenght) {
		setSide(lenght);
	}

	@Override
	public void setWidth(double width) {
		setSide(width);
	}
}
