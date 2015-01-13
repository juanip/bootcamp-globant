package logic;

import entities.Room;

public abstract class RoomKindFactory {
	public abstract Room getRoom(String type);
}
