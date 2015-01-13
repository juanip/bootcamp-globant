package entities;

public class RayRoom extends Room {

	public RayRoom(BathRoom bathroom) {
		super(bathroom);
	}

	public String toString() {
		return "The ray room with " + getBathroom();
	}

}
