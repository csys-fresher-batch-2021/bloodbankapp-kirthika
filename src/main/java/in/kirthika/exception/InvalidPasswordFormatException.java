package in.kirthika.exception;

public class InvalidPasswordFormatException extends Exception {

	/**
	 * method to return invalid password format
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPasswordFormatException(String message) {
		super(message);

	}

}
