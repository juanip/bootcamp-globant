package meetings.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Room {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "room")
	private List<Meeting> meetings = new ArrayList<Meeting>();

	public Room() {
	}

	public Room(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Long getID() {
		return this.id;
	}
}
