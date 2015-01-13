package entities;

public class MRIRoom extends Room {

	public MRIRoom(BathRoom bathroom) {
		super(bathroom);
	}

	public String toString() {
		return "The MRI room with " + getBathroom();
	}
}
