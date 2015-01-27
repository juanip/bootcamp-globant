package services;

import java.util.List;

import entities.User;

public interface IUserServices {

	public List<User> getUsers();

	public User getUser(long id);

	public User addUser(User user);

	public User updateUser(User user);

	public List<User> removeUser(long id);
}
