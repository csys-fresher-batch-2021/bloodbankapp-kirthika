package in.kirthika.exception;

public class InvalidNumberLengthException extends Exception {

	/**
	 * method to display mobile number length is invalid
	 */
	private static final long serialVersionUID = 1L;

	public InvalidNumberLengthException(String message) {
		super(message);

	}

}
