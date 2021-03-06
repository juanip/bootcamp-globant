package ex1_4;

import ex1_3.MyPoint;

public class MyCircle {

	private MyPoint center;
	private int radius;

	public MyCircle(int x, int y, int radius) {
		this(new MyPoint(x, y), radius);
	}

	public MyCircle(MyPoint center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public MyPoint getCenter() {
		return this.center;
	}

	public void setCenter(MyPoint center) {
		this.center = center;
	}

	public int getCenterX() {
		return getCenter().getX();
	}

	public int getCenterY() {
		return getCenter().getY();
	}

	public void setCenterXY(int x, int y) {
		this.center = new MyPoint(x, y);
	}

	public double getArea() {
		return Math.PI * getRadius() * getRadius();
	}

	@Override
	public String toString() {
		return "Circle @ (" + getCenterX() + ", " + getCenterY() + ") radius=" + getRadius();
	}
}