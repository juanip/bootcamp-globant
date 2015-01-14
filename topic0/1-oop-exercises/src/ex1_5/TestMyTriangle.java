package ex1_5;

import ex1_3.MyPoint;

public class TestMyTriangle {

	public static void main(String[] args) {
		MyPoint p11 = new MyPoint(0, 0);
		MyPoint p12 = new MyPoint(4, 3);
		MyPoint p13 = new MyPoint(0, 5);
		MyTriangle t1 = new MyTriangle(p11, p12, p13);
		System.out.println(t1);
		System.out.println(t1.getPerimeter());
		System.out.println(t1.printType());

		MyPoint p21 = new MyPoint(1, 1);
		MyPoint p22 = new MyPoint(1, 2);
		MyPoint p23 = new MyPoint(2, 2);
		MyTriangle t2 = new MyTriangle(p21, p22, p23);
		System.out.println(t2);
		System.out.println(t2.getPerimeter());
		System.out.println(t2.printType());

		MyPoint p31 = new MyPoint(5, 6);
		MyPoint p32 = new MyPoint(7, 9);
		MyPoint p33 = new MyPoint(14, 15);
		MyTriangle t3 = new MyTriangle(p31, p32, p33);
		System.out.println(t3);
		System.out.println(t3.getPerimeter());
		System.out.println(t3.printType());
	}
}
