package in.kirthika.exception;

public class InvalidDateException extends Exception {

	/**
	 * method to return date is not valid
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateException(String message) {
		super(message);

	}

}
