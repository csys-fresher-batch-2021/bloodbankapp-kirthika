package in.kirthika.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.kirthika.exception.EmptyStringException;
import in.kirthika.exception.InvalidNameException;
import in.kirthika.exception.InvalidNameFormatException;
import in.kirthika.exception.InvalidPasswordFormatException;

public class NameValidator {
	private NameValidator() {
		// default constructor
	}

	public static boolean isStringNotNullOrEmpty(String stringToValidate) throws EmptyStringException {

		if (stringToValidate == null || stringToValidate.trim().isEmpty()) {
			throw new EmptyStringException("Name cannot be Empty");
		}
		return true;
	}

	public static boolean invalidName(String stringToValidate) throws InvalidNameFormatException {
		
		String regex =("^([a-zA-Z])+([\\w]{2,})+$");
		Pattern regexPattern = Pattern.compile(regex);
		Matcher matchCheck = regexPattern.matcher(stringToValidate);
		boolean isValidFormat = matchCheck.matches();

		if (isValidFormat) {
			return true;
		} else {
			throw new InvalidNameFormatException(
					"Invalid user name");
		}
		
	}

	public static boolean isValidName(String donorName) throws InvalidNameException {
		try {
			isStringNotNullOrEmpty(donorName);
			invalidName(donorName);
			return true;
		} catch (EmptyStringException | InvalidNameFormatException e)// multi catch exception
		{
			throw new InvalidNameException(e.getMessage());
		}
	}
}
