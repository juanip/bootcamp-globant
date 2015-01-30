package meetings.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Attendee {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(mappedBy = "attendees")
	private List<Meeting> meetings = new ArrayList<Meeting>();

	private String name;

	public Attendee() {
	}

	public Attendee(String name) {
		this.name = name;
	}

	public Long getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

}
