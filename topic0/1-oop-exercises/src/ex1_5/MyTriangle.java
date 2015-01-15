package ex1_5;

import ex1_3.MyPoint;

public class MyTriangle {

	private static MyPoint[] points;

	public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this(new MyPoint(x1, y1), new MyPoint(x2, y2), new MyPoint(x3, y3));
	}

	public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
		this.points = new MyPoint[] { v1, v2, v3 };
	}

	@Override
	public String toString() {
		return "Triangle @ (" + points[0].getX() + ", " + points[0].getY() + "), (" + points[1].getX() + ", " + points[1].getY() + "), ("
				+ points[2].getX() + ", " + points[2].getY() + ")";
	}

	public double getPerimeter() {
		double perimeter = points[0].distance(points[1]);
		perimeter += points[1].distance(points[2]);
		perimeter += points[2].distance(points[0]);

		return perimeter;
	}

	public String printType() {
		double d1 = points[0].distance(points[1]);
		double d2 = points[1].distance(points[2]);
		double d3 = points[2].distance(points[0]);
		int count = 0;
		String type;

		if (d1 == d2)
			count++;
		if (d1 == d3)
			count++;
		if (d2 == d3)
			count++;

		if (count == 0) {
			type = "scalene";
		} else if (count == 1) {
			type = "isosceles";
		} else {
			type = "equilateral";
		}

		return type;
	}
}
