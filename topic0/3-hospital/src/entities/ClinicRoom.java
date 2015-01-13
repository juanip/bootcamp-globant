package entities;

public class ClinicRoom extends Room {

	public ClinicRoom(BathRoom bathroom) {
		super(bathroom);
	}

	public String toString() {
		return "The clinic room with " + getBathroom();
	}

}
