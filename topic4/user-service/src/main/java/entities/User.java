package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

	private long id;
	private String name;
	private List<Photo> photos = new ArrayList<Photo>();

	public User() {
	};

	public User(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void addPhoto(Photo photo) {
		this.photos.add(photo);
	}
}
