package shopping_cart.exceptions;

public class ClientSessionNotFound extends RuntimeException {

	public ClientSessionNotFound() {
		super("Session not found");
	}
}
