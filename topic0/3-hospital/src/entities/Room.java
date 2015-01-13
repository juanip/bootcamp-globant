package entities;

public class Room {
	private BathRoom bathroom = null;

	public Room(BathRoom bathroom) {
		this.bathroom = bathroom;
	}

	public BathRoom getBathroom() {
		return this.bathroom;
	}
}
