package ex1_6;

public class MyComplex {

	private double real;
	private double imag;

	public MyComplex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getReal() {
		return this.real;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public double getImag() {
		return this.imag;
	}

	public void setValue(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public String toString() {
		return "(" + getReal() + " + " + getImag() + "i)";
	}

	public boolean isReal() {
		return (this.imag == 0);
	}

	public boolean isImaginary() {
		return (this.real == 0);
	}

	public boolean equal(double real, double imag) {
		return (this.real == real && this.imag == imag);
	}

	public boolean equal(MyComplex another) {
		return (this.real == another.getReal() && this.imag == another.getImag());
	}

	public double magnitude() {
		return Math.sqrt(getReal() * getReal() + getImag() * getImag());
	}

	public double argumentInRadians() {
		return Math.atan2(getImag(), getReal());
	}

	public int argumentInDegrees() {
		return (int) ((argumentInRadians() * 180) / Math.PI);
	}

	public MyComplex conjugate() {
		return new MyComplex(getReal(), -getImag());
	}

	public MyComplex add(MyComplex another) {
		double r = getReal() + another.getReal();
		double i = getImag() + another.getImag();

		return new MyComplex(r, i);
	}

	public MyComplex subtract(MyComplex another) {
		double r = getReal() - another.getReal();
		double i = getImag() - another.getImag();

		return new MyComplex(r, i);
	}

	public MyComplex multiplyWith(MyComplex another) {
		double real = getReal() * another.getReal() - getImag() * another.getImag();
		double imag = getReal() * another.getImag() + getImag() * another.getReal();

		this.real = real;
		this.imag = imag;
		return this;
	}

	public MyComplex divideBy(MyComplex another) {
		another = another.conjugate();
		double real = getReal() * another.getReal() - getImag() * another.getImag();
		double imag = getReal() * another.getImag() + getImag() * another.getReal();
		double coef = another.getReal() * another.getReal() + another.getImag() * another.getImag();

		this.real = real / coef;
		this.imag = imag / coef;
		return this;
	}
}
