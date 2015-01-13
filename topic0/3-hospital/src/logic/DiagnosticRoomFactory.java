package logic;

import entities.BathRoom;
import entities.MRIRoom;
import entities.RayRoom;
import entities.Room;
import entities.TomographyRoom;

public class DiagnosticRoomFactory extends RoomKindFactory {

	@Override
	public Room getRoom(String type) {
		if (type == "MRI") {
			return new MRIRoom(new BathRoom());
		} else if (type == "ray") {
			return new RayRoom(new BathRoom());
		} else {
			return new TomographyRoom(new BathRoom());
		}
	}

}
