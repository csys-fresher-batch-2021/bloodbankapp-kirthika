package in.kirthika.exception;

public class InvalidPasswordException extends Exception {

	/**
	 * method to return invalid password
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordException(String message) {
		super(message);

	}

}
