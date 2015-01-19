package ex4_4;

public class ResizableCircle extends Circle implements Resizable {

	public ResizableCircle(double radius) {
		super(radius);
	}

	public ResizableCircle() {
		super();
	}

	@Override
	public double resize(int percent) {
		super.radius = percent * super.radius / 100;
		return super.radius;
	}
}
