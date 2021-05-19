package in.kirthika.util;

import in.kirthika.exception.EmptyStringException;

public class NameValidator {
	private NameValidator ()
	{
		//default constructor
	}
  

public static boolean isStringNotNullOrEmpty(String stringToValidate, String errorMessage) 
		throws EmptyStringException {

		
		if (stringToValidate == null || stringToValidate.trim().isEmpty()) {
			throw new EmptyStringException(errorMessage);
		}
		return true;
	}
}
