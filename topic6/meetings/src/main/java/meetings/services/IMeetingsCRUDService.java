package meetings.services;

import java.util.List;

import meetings.entities.Attendee;
import meetings.entities.Meeting;
import meetings.entities.Room;

public interface IMeetingsCRUDService {

	public List<Attendee> getAttendees();

	public Attendee getAttendee(Long id);

	public List<Room> getRooms();

	public Room getRoom(Long id);

	public List<Meeting> getMeetings();

	public Meeting getMeeting(Long id);

	public List<Meeting> getMeetings(Long roomID, int dd, int mm, int yyyy);

	public List<Meeting> getMeetings(Long roomID, int dd, int mm, int yyyy, int beginHour, int endHour);

	public Meeting addMeetings(Long roomID, int dd, int mm, int yyyy, int hour, int endHour, List<Attendee> attendees);

	public void removeMeeting(Long id);
}