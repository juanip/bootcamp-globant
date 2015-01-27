package entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUser() {
		User user = new User(1, "Juan Perez");
		assertEquals((long) 1, user.getId());
		assertEquals("Juan Perez", user.getName());
	}
}
