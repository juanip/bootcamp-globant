package meetings.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "time_slots")
public class TimeSlot {

	@Column(name = "month")
	private int month;
	@Column(name = "day")
	private int day;
	@Column(name = "year")
	private int year;
	@Column(name = "begin_hour")
	private int beginHour;
	@Column(name = "end_hour")
	private int endHour;

	@Id
	@GeneratedValue
	@Column(name = "time_slot_id")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "timeSlot")
	private Meeting meeting;

	public TimeSlot() {
	}

	public TimeSlot(int year, int month, int day, int beginHour, int endHour) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.beginHour = beginHour;
		this.endHour = endHour;
	}

	public int getBeginHour() {
		return beginHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public boolean sameDay(TimeSlot timeSlot) {
		if (day == timeSlot.getDay() && month == timeSlot.getMonth() && year == timeSlot.getYear()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean overlappingTime(TimeSlot timeSlot) {
		if (beginHour < timeSlot.getEndHour() && beginHour >= timeSlot.getBeginHour()) {
			return true;
		} else if (endHour < timeSlot.getEndHour() && endHour >= timeSlot.getBeginHour()) {
			return true;
		} else if (beginHour < timeSlot.getBeginHour() && endHour >= timeSlot.getEndHour()) {
			return true;
		} else {
			return false;
		}
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}
}
