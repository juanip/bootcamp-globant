package logic;

import entities.BathRoom;
import entities.NeonatalRoom;
import entities.PediatricRoom;
import entities.Room;

public class ChildRoomFactory extends RoomKindFactory {

	@Override
	public Room getRoom(String type) {
		if (type == "neonatal") {
			return new NeonatalRoom(new BathRoom());
		} else {
			return new PediatricRoom(new BathRoom());
		}
	}

}
