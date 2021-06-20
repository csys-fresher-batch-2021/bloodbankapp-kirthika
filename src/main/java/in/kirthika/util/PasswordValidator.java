package in.kirthika.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.kirthika.exception.EmptyPasswordException;

import in.kirthika.exception.InvalidPasswordException;
import in.kirthika.exception.InvalidPasswordFormatException;

public class PasswordValidator {

	private PasswordValidator() {
		// default constructor
	}
/**
 * method to check password is null or empty
 * @param passwordToValidate
 * @return
 * @throws EmptyPasswordException
 */
	public static boolean isStringNotNullOrEmpty(String passwordToValidate) throws EmptyPasswordException {

		if (passwordToValidate == null || passwordToValidate.trim().isEmpty()) {
			throw new EmptyPasswordException("Password cannot be Empty");
		}
		return true;
	}
/**
 * method to check password format
 * @param passwordToValidate
 * @return
 * @throws InvalidPasswordFormatException
 */
	public static boolean invalidPassword(String passwordToValidate) throws InvalidPasswordFormatException {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
		Pattern regexPattern = Pattern.compile(regex);
		Matcher matchCheck = regexPattern.matcher(passwordToValidate);
		boolean isValidFormat = matchCheck.matches();

		if (isValidFormat) {
			return true;
		} else {
			throw new InvalidPasswordFormatException(
					"Invalid password format");
		}
	}
/**
 * method to check valid password format
 * @param userPassword
 * @return
 * @throws InvalidPasswordException
 */
	public static boolean isValidFormat(String userPassword) throws InvalidPasswordException {
		try {
			isStringNotNullOrEmpty(userPassword);
			invalidPassword(userPassword);
			return true;
		} catch (EmptyPasswordException | InvalidPasswordFormatException e)// multi catch exception
		{
			throw new InvalidPasswordException(e.getMessage());
		}

	}
}
