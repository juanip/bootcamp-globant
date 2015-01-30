package meetings.services;

import java.util.ArrayList;
import java.util.List;

import meetings.data.AttendeeRepository;
import meetings.data.MeetingRepository;
import meetings.data.RoomRepository;
import meetings.entities.Attendee;
import meetings.entities.Meeting;
import meetings.entities.Room;
import meetings.entities.TimeSlot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingsCRUDService implements IMeetingsCRUDService {

	private RoomRepository roomRepository;
	private AttendeeRepository attendeeRepository;
	private MeetingRepository meetingRepository;

	public MeetingsCRUDService() {
	}

	@Autowired
	public MeetingsCRUDService(RoomRepository roomRepository, AttendeeRepository attendeeRepository, MeetingRepository meetingRepository) {
		this.roomRepository = roomRepository;
		this.attendeeRepository = attendeeRepository;
		this.meetingRepository = meetingRepository;
	}

	@Override
	public List<Attendee> getAttendees() {
		return attendeeRepository.findAll();
	}

	@Override
	public Attendee getAttendee(Long id) {
		return attendeeRepository.findById(id);
	}

	@Override
	public List<Room> getRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room getRoom(Long id) {
		return roomRepository.findById(id);
	}

	@Override
	public List<Meeting> getMeetings() {
		return meetingRepository.findAll();
	}

	@Override
	public Meeting getMeeting(Long id) {
		return meetingRepository.findById(id);
	}

	@Override
	public List<Meeting> getMeetings(Long roomID, int dd, int mm, int yyyy) {
		TimeSlot timeSlot = new TimeSlot(yyyy, mm, dd, 0, 0);
		List<Meeting> aux, meetings;
		aux = meetingRepository.findByRoom(findRoom(roomID));
		meetings = new ArrayList<Meeting>();

		for (Meeting m : aux) {
			if (m.getTimeSlot().sameDay(timeSlot)) {
				meetings.add(m);
			}
		}

		return meetings;
	}

	@Override
	public List<Meeting> getMeetings(Long roomID, int dd, int mm, int yyyy, int beginHour, int endHour) {
		TimeSlot timeSlot = new TimeSlot(yyyy, mm, dd, beginHour, endHour);
		List<Meeting> aux, meetings;
		aux = meetingRepository.findByRoom(findRoom(roomID));
		meetings = new ArrayList<Meeting>();

		for (Meeting m : aux) {
			if (m.getTimeSlot().sameDay(timeSlot) && m.getTimeSlot().overlappingTime(timeSlot)) {
				meetings.add(m);
			}
		}

		return meetings;
	}

	@Override
	public Meeting addMeetings(Long roomID, int dd, int mm, int yyyy, int beginHour, int endHour, List<Attendee> attendees) {
		TimeSlot timeSlot = new TimeSlot(yyyy, mm, dd, beginHour, endHour);
		List<Attendee> attendee = new ArrayList<Attendee>();
		for (Attendee a : attendees) {
			attendee.add(attendeeRepository.findById(a.getID()));
		}

		return meetingRepository.save(new Meeting(timeSlot, findRoom(roomID), attendee));
	}

	@Override
	public void removeMeeting(Long id) {
		Meeting m = meetingRepository.findById(id);
		if (m == null) {
			throw new MeetingNotFoundException();
		} else {
			meetingRepository.delete(m);
		}
	}

	private Room findRoom(Long id) {
		Room room = roomRepository.findById(id);
		if (room == null) {
			throw new RoomNotFoundException();
		}

		return room;
	}

	class RoomNotFoundException extends RuntimeException {
		public RoomNotFoundException() {
			super("Room not found!");
		}
	}

	class MeetingNotFoundException extends RuntimeException {
		public MeetingNotFoundException() {
			super("Meeting not found!");
		}
	}
}
