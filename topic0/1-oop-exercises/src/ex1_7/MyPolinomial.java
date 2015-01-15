package ex1_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyPolinomial {
	private double[] coeff;

	public MyPolinomial(double... coeff) {
		this.coeff = coeff;
	}

	public MyPolinomial(String filename) {
		Scanner in = null;
		try {
			in = new Scanner(new File(filename)); // open file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int degree = in.nextInt(); // read the degree

		double[] coeffs = new double[degree + 1]; // allocate the array
		for (int i = 0; i < coeffs.length; ++i) {
			coeffs[i] = in.nextDouble();
		}

		this.coeff = coeffs;
	}

	public int getDegree() {
		return this.coeff.length - 1;
	}

	@Override
	public String toString() {
		String str = this.coeff[this.coeff.length - 1] + "x^" + (this.coeff.length - 1);

		for (int i = this.coeff.length - 2; i > 0; i--) {
			str += " + " + this.coeff[i] + "x^" + i;
		}

		return str;
	}

	public double evaluate(double x) {
		double result = 0;

		for (int i = 0; i < this.coeff.length; i++) {
			result += this.coeff[i] * (Math.pow(x, i));
		}

		return result;
	}

	public MyPolinomial add(MyPolinomial another) {
		double[] coeff1 = this.coeff;
		double[] coeff2 = another.getCoeffs();
		boolean coeff1MinLength;
		int length;

		coeff1MinLength = coeff1.length < coeff2.length;

		length = coeff1MinLength ? coeff1.length : coeff2.length;

		for (int i = 0; i < length; i++) {
			if (coeff1MinLength) {
				coeff2[i] += coeff1[i];
			} else {
				coeff1[i] += coeff2[i];
			}
		}

		if (coeff1MinLength) {
			return new MyPolinomial(coeff2);
		} else {
			return new MyPolinomial(coeff2);
		}

	}

	public MyPolinomial multiply(MyPolinomial another) {
		return null;
	}

	public double[] getCoeffs() {
		return this.coeff;
	}
}
