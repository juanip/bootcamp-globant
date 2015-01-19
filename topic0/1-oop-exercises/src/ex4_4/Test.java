package ex4_4;

public class Test {

	public static void main(String[] args) {
		ResizableCircle circle = new ResizableCircle(15);

		System.out.println(circle);

		circle.resize(50);
		System.out.println(circle);

		circle.resize(101);
		System.out.println(circle);

		circle.resize(120);
		System.out.println(circle);
	}
}
