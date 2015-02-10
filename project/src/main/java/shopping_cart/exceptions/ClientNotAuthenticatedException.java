package shopping_cart.exceptions;

public class ClientNotAuthenticatedException extends RuntimeException {

	public ClientNotAuthenticatedException() {
		super("The client is not authenticated");
	}
}
