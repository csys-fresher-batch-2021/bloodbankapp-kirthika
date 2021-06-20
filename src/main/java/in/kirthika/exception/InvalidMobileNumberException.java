package in.kirthika.exception;

public class InvalidMobileNumberException extends Exception {

	/**
	 * method to return mobile number is invalid
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMobileNumberException(String message) {
		super(message);

	}

}
