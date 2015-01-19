package ex1_13;

public class Ball {

	private int x;
	private int y;
	private int radius;
	private double xDelta;
	private double yDelta;

	public Ball(int x, int y, int radius, int speed, int direction) {
		if (direction <= -180 || direction > 180) {
			throw new RuntimeException("Direction invalid");
		}

		this.x = x;
		this.y = y;
		this.radius = radius;

		this.xDelta = speed * Math.cos(direction);
		this.yDelta = -speed * Math.sin(direction);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getxDelta() {
		return xDelta;
	}

	public void setxDelta(double xDelta) {
		this.xDelta = xDelta;
	}

	public double getyDelta() {
		return yDelta;
	}

	public void setyDelta(double yDelta) {
		this.yDelta = yDelta;
	}

	public void move() {
		x += xDelta;
		y += yDelta;
	}

	public void reflectHorizontal() {
		xDelta = -xDelta;
	}

	public void reflectVertical() {
		yDelta = -yDelta;
	}

	@Override
	public String toString() {
		return "Ball at (" + x + ", " + y + ") of velocity (" + xDelta + ", " + yDelta + ").";
	}
}
