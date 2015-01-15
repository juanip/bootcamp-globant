package ex1_9;

public class TestMyTime {

	public static void main(String[] args) {
		MyTime time1 = new MyTime(20, 56, 58);
		MyTime time2 = new MyTime(20, 59, 58);
		MyTime time3 = new MyTime(23, 59, 58);

		for (int i = 0; i < 4; i++) {
			System.out.println(time1.nextSecond());
			System.out.println(time2.nextSecond());
			System.out.println(time3.nextSecond());
			System.out.println("");
		}
	}

}
