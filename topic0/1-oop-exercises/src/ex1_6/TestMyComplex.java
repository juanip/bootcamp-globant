package ex1_6;

public class TestMyComplex {
	public static void main(String[] args) {
		MyComplex complex = new MyComplex(3, 2);

		System.out.println(complex);
		System.out.println(complex.isReal());
		System.out.println(complex.isImaginary());
		System.out.println(complex.equal(0, 0));
		System.out.println(complex.equal(new MyComplex(3, 2)));
		System.out.println(complex.magnitude());
		System.out.println(complex.conjugate());
		System.out.println(complex.argumentInRadians());
		System.out.println(complex.argumentInDegrees());
		System.out.println(complex.add(new MyComplex(4, -3)));
		System.out.println(complex.subtract(new MyComplex(4, -3)));
		System.out.println(complex.multiplyWith(new MyComplex(4, -3)));
		System.out.println(complex.divideBy(new MyComplex(4, -3)));
	}
}
