package in.kirthika.exception;

public class DonorAlreadyExist extends Exception {

	/**
	 * Method to return donor already present 
	 */
	private static final long serialVersionUID = 1L;

	public DonorAlreadyExist(String message) {
		super(message);

	}

}
