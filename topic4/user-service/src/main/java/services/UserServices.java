package services;

import java.util.List;

import data.UserRepository;
import entities.User;

public class UserServices implements IUserServices {

	private UserRepository userRepository = UserRepository.getInstance();

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public User getUser(long id) {
		return userRepository.getUser(id);
	}

	@Override
	public User addUser(User user) {
		return userRepository.addUser(user.getName());
	}

	@Override
	public User updateUser(User user) {
		return userRepository.updateUser(user.getId(), user.getName());
	}

	@Override
	public List<User> removeUser(long id) {
		userRepository.removeUser(id);
		return userRepository.getUsers();
	}

}
