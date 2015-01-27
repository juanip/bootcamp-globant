package data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entities.User;

public class UserRepositoryTest {

	private UserRepository userRepository = UserRepository.getInstance();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUserRepository() {
		User user = userRepository.addUser("Juan Perez");
		assertEquals("Juan Perez", userRepository.getUser(user.getId()).getName());
	}

	@Test
	public void testUpdateUser() {
		User user = userRepository.addUser("Emilio Rodriguez");
		userRepository.updateUser(user.getId(), "Emilio Suarez");
		assertEquals("Emilio Suarez", userRepository.getUser(user.getId()).getName());
	}

	@Test
	public void testRemoveUser() {
		long id = userRepository.addUser("Osvaldo Fernandez").getId();
		assertEquals("Osvaldo Fernandez", userRepository.getUser(id).getName());

		userRepository.removeUser(id);

		try {
			userRepository.getUser(id);
		} catch (RuntimeException e) {
			assertEquals("User not found", e.getMessage());
		}
	}
}
