package ex1_4;

import ex1_3.MyPoint;

public class MyCircleTest {
	public static void main(String[] args) {
		// Test program
		MyPoint p1 = new MyPoint(1, 1);
		MyCircle c1 = new MyCircle(p1, 2);

		MyCircle c2 = new MyCircle(1, 2, 3);

		System.out.println(c1);
		System.out.println(c1.getRadius());
		System.out.println(c1.getCenter());

		System.out.println(c2);
		System.out.println(c2.getCenterX());
		System.out.println(c2.getCenterY());

		c1.setCenterXY(5, 6);
		c1.setRadius(4);
		System.out.println(c1);
		System.out.println(c1.getArea());
	}

}
