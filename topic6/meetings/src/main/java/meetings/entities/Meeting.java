package meetings.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "meetings")
public class Meeting {

	@Id
	@GeneratedValue
	@Column(name = "meeting_id")
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "meetings_attendees", joinColumns = { @JoinColumn(name = "meeting_id") }, inverseJoinColumns = { @JoinColumn(name = "attendee_id") })
	private List<Attendee> attendees;

	@OneToOne(cascade = CascadeType.ALL)
	private TimeSlot timeSlot;

	@ManyToOne(cascade = CascadeType.ALL)
	private Room room;

	public Meeting() {
	}

	public Meeting(TimeSlot timeSlot, Room room, List<Attendee> attendees) {
		this.timeSlot = timeSlot;
		this.room = room;
		this.attendees = attendees;
	}

	public List<Attendee> getAttendees() {
		return this.attendees;
	}

	public TimeSlot getTimeSlot() {
		return this.timeSlot;
	}

	public Room getRoom() {
		return this.room;
	}

	public Long getID() {
		return this.id;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}
}
