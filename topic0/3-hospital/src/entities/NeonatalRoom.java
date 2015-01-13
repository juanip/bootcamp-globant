package entities;

public class NeonatalRoom extends Room {

	public NeonatalRoom(BathRoom bathroom) {
		super(bathroom);
	}

	public String toString() {
		return "The neonatal room with " + getBathroom();
	}

}
