package logic;

import entities.BathRoom;
import entities.ClinicRoom;
import entities.Room;
import entities.TerapyRoom;

public class InternmentRoomFactory extends RoomKindFactory {

	@Override
	public Room getRoom(String type) {
		if (type == "clinic") {
			return new ClinicRoom(new BathRoom());
		} else {
			return new TerapyRoom(new BathRoom());
		}
	}

}
