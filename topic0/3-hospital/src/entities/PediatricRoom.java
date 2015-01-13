package entities;

public class PediatricRoom extends Room {

	public PediatricRoom(BathRoom bathroom) {
		super(bathroom);
	}

	public String toString() {
		return "The pediatric room with " + getBathroom();
	}
}
