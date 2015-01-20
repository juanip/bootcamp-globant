package ex6_1;

public class Test {

	public static void main(String[] args) {

		MyIntStack stack = new MyIntStack(10);

		stack.push(42);
		stack.push(14);
		stack.push(8);

		System.out.println(stack.pop());
		System.out.println(stack.pop());

		stack.push(6);
		System.out.println(stack.pop());
	}
}
