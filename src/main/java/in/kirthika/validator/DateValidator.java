package in.kirthika.validator;

import java.time.LocalDate;

import in.kirthika.exception.InvalidDateException;

public class DateValidator {

	private DateValidator() {
		// default constructor
	}
/**
 * method to validate date
 * @param date
 * @param errorMessage
 * @return
 * @throws InvalidDateException
 */
	public static boolean isValidDate(LocalDate date, String errorMessage) throws InvalidDateException

	{
		if (date.isBefore(LocalDate.now())) {
			throw new InvalidDateException(errorMessage);
		}
		return true;
	}
}
