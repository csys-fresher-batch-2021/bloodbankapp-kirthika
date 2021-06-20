package in.kirthika.validator;

import in.kirthika.exception.InvalidAgeException;

public class AgeValidator {
	private AgeValidator() {
		// default constructor
	}
/**
 * method to check donor age is eligible to donate
 * @param age
 * @param errorMessage
 * @return
 * @throws InvalidAgeException
 */
	public static boolean isEligibleDonor(int age, String errorMessage) throws InvalidAgeException {
		if (age <= 60 && age >= 18) {
			return true;
		} else {
			throw new InvalidAgeException(errorMessage);
		}
	}

}
