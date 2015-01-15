package ex1_3;

public class MyPoint {

	private int x;
	private int y;

	public MyPoint() {
		this(0, 0);
	}

	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}

	@Override
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	public double distance(int x, int y) { // this version takes two ints as
											// arguments
		return distance(new MyPoint(x, y));
	}

	public double distance(MyPoint another) { // this version takes a MyPoint
												// instance as argument
		int xDiff = this.x - another.getX();
		int yDiff = this.y - another.getY();
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}
}
