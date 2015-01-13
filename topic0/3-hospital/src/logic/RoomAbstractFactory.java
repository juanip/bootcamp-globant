package logic;

public class RoomAbstractFactory {
	public RoomKindFactory getRoomKindFactory(String type) {
		if (type == "diagnostic") {
			return new DiagnosticRoomFactory();
		} else if (type == "internment") {
			return new InternmentRoomFactory();
		} else {
			return new ChildRoomFactory();
		}
	}
}
