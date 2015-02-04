package shopping_cart.exceptions;

public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException(String user) {
		super("Client " + "\"" + user + "\"" + "not found");
	}
}
