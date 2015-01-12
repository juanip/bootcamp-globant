package ex1_3;

public class TestMyPoint {

	public static void main(String[] args) {
		// Test program
		MyPoint p1 = new MyPoint(3, 0);
		MyPoint p2 = new MyPoint(0, 4);

		// Testing the overloaded method distance()
		System.out.println(p1.distance(p2)); // which version?
		System.out.println(p1.distance(5, 6)); // which version?

		// 2)
		MyPoint[] points = new MyPoint[10]; // Declare and allocate an array of
											// MyPoint
		for (int i = 0; i < 10; i++) {
			points[i] = new MyPoint(i + 1, i + 1); // Allocate each of MyPoint
													// instances
		}

	}
}
