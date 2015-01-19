package ex4_3;

public class MovableCircle implements Movable {

	private MovablePoint center;
	private int radius;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	@Override
	public void moveUp() {
		center.y -= center.ySpeed;
	}

	@Override
	public void moveDown() {
		center.y += center.ySpeed;
	}

	@Override
	public void moveLeft() {
		center.x -= center.x;

	}

	@Override
	public void moveRight() {
		center.x += center.x;
	}

	@Override
	public String toString() {
		return "Circle: with radius=" + radius + " and center at " + center.toString();
	}
}
