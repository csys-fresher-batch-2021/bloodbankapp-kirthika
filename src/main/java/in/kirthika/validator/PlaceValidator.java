package in.kirthika.validator;

import in.kirthika.exception.InvalidPlaceException;

public class PlaceValidator {
	private PlaceValidator() {
		// default constructor
	}
/**
 * method to validate place
 * @param place
 * @param errorMessage
 * @return
 * @throws InvalidPlaceException
 */
	public static boolean donorPlaceValidator(String place, String errorMessage) throws InvalidPlaceException {
		if (place == null || place.trim().isEmpty() || place.equalsIgnoreCase("Select a District")) {
			throw new InvalidPlaceException(errorMessage);
		}
		return true;
	}

}
