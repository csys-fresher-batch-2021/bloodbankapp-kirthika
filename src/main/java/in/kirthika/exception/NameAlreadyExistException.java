package in.kirthika.exception;

public class NameAlreadyExistException extends Exception {

	/**
	 * method to return name already exist
	 */
	private static final long serialVersionUID = 1L;

	public NameAlreadyExistException(String message) {
		super(message);
		
	}

}
