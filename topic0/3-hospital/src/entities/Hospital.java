package entities;

import java.util.ArrayList;

public class Hospital {

	private ArrayList<Room> diagnosticRooms = new ArrayList<Room>();
	private ArrayList<Room> internmentRooms = new ArrayList<Room>();
	private ArrayList<Room> childRooms = new ArrayList<Room>();

	public void addDiagnosticRoom(Room room) {
		this.diagnosticRooms.add(room);
	}

	public void addInternmentRoom(Room room) {
		this.internmentRooms.add(room);
	}

	public void addChildRoom(Room room) {
		this.childRooms.add(room);
	}

	public String toString() {
		String desc = "A hospital with:\n";

		for (Room r : this.diagnosticRooms) {
			desc += r + "\n";
		}
		for (Room r : this.internmentRooms) {
			desc += r + "\n";
		}
		for (Room r : this.childRooms) {
			desc += r + "\n";
		}

		return desc;
	}
}
