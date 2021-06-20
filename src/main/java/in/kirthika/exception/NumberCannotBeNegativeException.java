package in.kirthika.exception;

public class NumberCannotBeNegativeException extends Exception {

	/**
	 * method to return mobile number cannot be negative
	 */
	private static final long serialVersionUID = 1L;

	public NumberCannotBeNegativeException(String message) {
		super(message);

	}

}
