package in.kirthika.validator;

import in.kirthika.exception.EmptyBloodGroupException;

public class BloodGroupValidator {
	private BloodGroupValidator() {
		// default constructor
	}
/**
 * method to check age is blood group is valid or not
 * @param bloodGroup
 * @param errorMessage
 * @return
 * @throws EmptyBloodGroupException
 */
	public static boolean donorBloodGroupValidator(String bloodGroup, String errorMessage)
			throws EmptyBloodGroupException {
		if (bloodGroup.length() > 3) {
			throw new EmptyBloodGroupException(errorMessage);
		}
		return true;
	}
}
