package ex3_1;

public class Point {
	// Private variables
	private int x; // x co-ordinate
	private int y; // y co-ordinate

	// Constructor
	public Point(int x, int y) {
		setX(x);
		setY(y);
	}

	// Public methods
	public String toString() {
		return "Point: (" + x + "," + y + ")";
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setXY(int x, int y) {
		setX(x);
		setY(y);
	}
}
