package entities;

public class TerapyRoom extends Room {

	public TerapyRoom(BathRoom bathroom) {
		super(bathroom);
	}

	public String toString() {
		return "The terapy room with " + getBathroom();
	}
}
