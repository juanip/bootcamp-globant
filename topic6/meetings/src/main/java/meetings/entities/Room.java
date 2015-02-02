package meetings.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "room_id")
	private Long id;

	@Column(name = "name")
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
