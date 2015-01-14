package ex1_6;

import java.util.Scanner;

public class MyComplexApp {

	public static void main(String[] args) {
		String input1;
		String input2;
		MyComplex complex1;
		MyComplex complex2;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter complex number 1 (real and imaginary part):");
		input1 = scanner.nextLine();

		System.out.println("Enter complex number 2 (real and imaginary part):");
		input2 = scanner.nextLine();

		scanner.close();

		complex1 = getComplex(input1);
		complex2 = getComplex(input2);

		System.out.println("Number 1 is: " + complex1);

		if (complex1.isReal()) {
			System.out.println(complex1 + "  is a pure real number");
		} else {
			System.out.println(complex1 + "  is a NOT pure real number");
		}

		if (complex1.isImaginary()) {
			System.out.println(complex1 + "  is a pure imaginary number");
		} else {
			System.out.println(complex1 + "  is a NOT pure imaginary number");
		}

		System.out.println("Number 2 is: " + complex2);

		if (complex2.isReal()) {
			System.out.println(complex2 + "  is a pure real number");
		} else {
			System.out.println(complex2 + "  is a NOT pure real number");
		}

		if (complex2.isImaginary()) {
			System.out.println(complex2 + "  is a pure imaginary number");
		} else {
			System.out.println(complex2 + "  is a NOT pure imaginary number");
		}

		if (complex1.equal(complex2)) {
			System.out.println(complex1 + " is equal to " + complex2);
		} else {
			System.out.println(complex1 + " is NOT equal to " + complex2);
		}

		// add
		System.out.println(complex1 + " + " + complex2 + " = " + complex1.add(complex2));

		// subtract

		System.out.println(complex1 + " - " + complex2 + " = " + complex1.subtract(complex2));
	}

	private static MyComplex getComplex(String input) {
		String[] output;
		double real;
		double imag;

		output = input.split(" ");
		real = Double.parseDouble(output[0]);
		imag = Double.parseDouble(output[1]);

		return new MyComplex(real, imag);
	}
}
