package meetings.controllers;

import java.util.List;

import meetings.entities.Attendee;
import meetings.entities.Meeting;
import meetings.entities.Room;
import meetings.services.IMeetingsCRUDService;
import meetings.services.MeetingsCRUDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MeetingController {

	@Autowired
	private IMeetingsCRUDService meetingsCRUDService = new MeetingsCRUDService();

	// attendees
	@RequestMapping(value = "attendees", method = RequestMethod.GET)
	public @ResponseBody List<Attendee> getAttendees() {
		return meetingsCRUDService.getAttendees();
	}

	// attendees/{id}
	@RequestMapping(value = "attendees/{id}", method = RequestMethod.GET)
	public @ResponseBody Attendee getAttendee(@PathVariable Long id) {
		return meetingsCRUDService.getAttendee(id);
	}

	// rooms
	@RequestMapping(value = "rooms", method = RequestMethod.GET)
	public @ResponseBody List<Room> getRooms() {
		return meetingsCRUDService.getRooms();
	}

	// rooms/{id}
	@RequestMapping(value = "rooms/{id}", method = RequestMethod.GET)
	public @ResponseBody Room getRoom(@PathVariable Long id) {
		return meetingsCRUDService.getRoom(id);
	}

	// rooms/{id}/{dd}-{mm}-{yyyy}
	@RequestMapping(value = "rooms/{roomID}/{dd}-{mm}-{yyyy}", method = RequestMethod.GET)
	public @ResponseBody List<Meeting> addMeeting(@PathVariable Long roomID, @PathVariable int dd, @PathVariable int mm,
			@PathVariable int yyyy) {
		return meetingsCRUDService.getMeetings(roomID, dd, mm, yyyy);
	}

	// rooms/{id}/{dd}-{mm}-{yyyy}/{beginhour}to{endHour}
	@RequestMapping(value = "rooms/{roomID}/{dd}-{mm}-{yyyy}/{beginHour}to{endHour}", method = RequestMethod.GET)
	public @ResponseBody List<Meeting> addMeeting(@PathVariable Long roomID, @PathVariable int dd, @PathVariable int mm,
			@PathVariable int yyyy, @PathVariable int beginHour, @PathVariable int endHour) {
		return meetingsCRUDService.getMeetings(roomID, dd, mm, yyyy, beginHour, endHour);
	}

	// rooms/{id}/{dd}-{mm}-{yyyy}/{beginhour}to{endHour}
	@RequestMapping(value = "rooms/{roomID}/{dd}-{mm}-{yyyy}/{beginHour}to{endHour}", method = RequestMethod.POST)
	public @ResponseBody Meeting addMeeting(@PathVariable Long roomID, @PathVariable int dd, @PathVariable int mm, @PathVariable int yyyy,
			@PathVariable int beginHour, @PathVariable int endHour, @RequestBody List<Attendee> attendees) {
		return meetingsCRUDService.addMeetings(roomID, dd, mm, yyyy, beginHour, endHour, attendees);
	}

	// meetings
	@RequestMapping(value = "meetings", method = RequestMethod.GET)
	public @ResponseBody List<Meeting> getMeetings() {
		return meetingsCRUDService.getMeetings();
	}

	// meetings/{id}
	@RequestMapping(value = "meetings/{id}", method = RequestMethod.GET)
	public @ResponseBody Meeting getMeeting(@PathVariable Long id) {
		return meetingsCRUDService.getMeeting(id);
	}

	// meetings/{id}
	@RequestMapping(value = "meetings/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String removeMeeting(@PathVariable Long id) {
		meetingsCRUDService.removeMeeting(id);
		String quotes = "\"";
		return "{" + quotes + "id" + quotes + ":" + "1," + quotes + "value" + quotes + ":" + quotes + "The meeting has been remove."
				+ quotes + "}";
	}
}
