package ex4_1;

public class Square extends Rectangle {

	public Square() {
		this(1.0);
	}

	public Square(double side) {
		super(side, side);
	}

	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}

	public double getSide() {
		return super.getLength();
	}

	public void setSide(double side) {
		super.setLength(side);
		super.setWidth(side);
	}

	@Override
	public void setLength(double side) {
		super.setLength(side);
		super.setWidth(side);
	}

	@Override
	public void setWidth(double side) {
		super.setLength(side);
		super.setWidth(side);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("A square of side=" + getSide() + ", color=" + getColor() + " and ");
		sb.append(isFilled() ? "filled" : "not filled");

		return sb.toString();
	}
}
