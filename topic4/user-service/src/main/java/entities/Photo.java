package entities;

import java.io.File;

public class Photo {

	private String name;
	private final File file;
	private final long id;
	private final User user;

	public Photo(long id, String name, File file, User user) {
		this.id = id;
		this.name = name;
		this.file = file;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getFile() {
		return file;
	}

	public long getId() {
		return id;
	}

	public User getUser() {
		return this.user;
	}
}
