package shopping_cart.exceptions;

public class UserUnavailableException extends RuntimeException {

	public UserUnavailableException() {
		super("User not available!");
	}
}
