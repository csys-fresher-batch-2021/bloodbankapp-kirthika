package in.kirthika.exception;

public class EmptyPasswordException extends Exception {

	/**
	 *  method to return password field is empty
	 */
	private static final long serialVersionUID = 1L;

	public EmptyPasswordException(String message) {
		super(message);

	}

}
