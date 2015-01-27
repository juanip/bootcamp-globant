package data;

import java.util.ArrayList;
import java.util.List;

import entities.User;
import entities.UserNotFoundException;

public class UserRepository {

	private static UserRepository instance;
	private static long nextID = 0;

	public static UserRepository getInstance() {
		if (instance == null) {
			instance = new UserRepository();
		}

		return instance;
	}

	private static long getNextID() {
		nextID++;
		return nextID - 1;
	}

	private List<User> users = new ArrayList<User>();

	// singleton
	private UserRepository() {
	}

	public User addUser(String name) {
		User user = new User(getNextID(), name);
		this.users.add(user);
		return user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public User getUser(long id) {
		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}

		throw new UserNotFoundException();
	}

	public User updateUser(long id, String name) {
		for (User u : users) {
			if (u.getId() == id) {
				u.setName(name);
				return u;
			}
		}

		throw new UserNotFoundException();
	}

	public void removeUser(long id) {
		User user = null;
		for (User u : users) {
			if (u.getId() == id) {
				user = u;
			}
		}
		if (user != null) {
			users.remove(user);
		} else {
			throw new UserNotFoundException();
		}
	}

	public boolean existUser(long userID) {
		boolean flag = false;
		for (User u : this.users) {
			if (u.getId() == userID) {
				flag = true;
				break;
			}
		}

		return flag;
	}

}
