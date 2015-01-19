package ex3_1;

public class TestLine {
	public static void main(String[] args) {
		LineSub l1 = new LineSub(0, 0, 3, 5);
		System.out.println(l1);

		Point p1 = new Point(2, 4);
		Point p2 = new Point(0, 0);
		LineSub l2 = new LineSub(p1, p2);
		System.out.println(l2);

		System.out.println(l1.getLength());
		System.out.println(l2.getGradient());
	}
}
