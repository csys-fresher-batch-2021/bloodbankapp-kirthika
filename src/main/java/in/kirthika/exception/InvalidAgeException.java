package in.kirthika.exception;

public class InvalidAgeException extends Exception {

	/**
	 * method to return age is not valid
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAgeException(String message) {
		super(message);

	}

}
