package entities;

public class TomographyRoom extends Room {

	public TomographyRoom(BathRoom bathroom) {
		super(bathroom);
	}

	public String toString() {
		return "The tomography room with " + getBathroom();
	}
}
