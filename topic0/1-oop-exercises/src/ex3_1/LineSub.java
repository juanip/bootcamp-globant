package ex3_1;

public class LineSub extends Point {
	// A line needs two points: begin and end.
	// The begin point is inherited from its superclass Point.
	// Private variables
	Point end; // Ending point

	// Constructors
	public LineSub(int beginX, int beginY, int endX, int endY) {
		super(beginX, beginY); // construct the begin Point
		this.end = new Point(endX, endY); // construct the end Point
	}

	public LineSub(Point begin, Point end) { // caller to construct the Points
		super(begin.getX(), begin.getY()); // need to reconstruct the begin
											// Point
		this.end = end;
	}

	// Public methods
	// Inherits methods getX() and getY() from superclass Point
	public String toString() {
		return "Line:\n Begin (" + super.toString() + "\n End " + end;
	}

	public Point getBegin() {
		return new Point(super.getX(), super.getY());
	}

	public Point getEnd() {
		return this.end;
	}

	public void setBegin(Point begin) {
		super.setXY(begin.getX(), begin.getY());
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public int getBeginX() {
		return super.getX();
	}

	public int getBeginY() {
		return super.getY();
	}

	public int getEndX() {
		return end.getX();
	}

	public int getEndY() {
		return end.getY();
	}

	public void setBeginX(int x) {
		super.setX(x);
	}

	public void setBeginY(int y) {
		super.setY(y);
	}

	public void setBeginXY(int x, int y) {
		super.setXY(x, y);
	}

	public void setEndX(int x) {
		end.setX(x);
	}

	public void setEndY(int y) {
		end.setY(y);
	}

	public void setEndXY(int x, int y) {
		end.setXY(x, y);
	}

	public double getLength() {
		double xDiff = super.getX() - end.getX();
		double yDiff = super.getY() - end.getY();

		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	} // Length of the line

	public double getGradient() {
		double xDiff = super.getX() - end.getX();
		double yDiff = super.getY() - end.getY();

		return Math.atan2(yDiff, xDiff);
	} // Gradient in radians
}
