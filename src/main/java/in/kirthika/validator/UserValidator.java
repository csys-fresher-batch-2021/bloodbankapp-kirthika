package in.kirthika.validator;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;



import in.kirthika.dao.UserManagerDao;
import in.kirthika.exception.NameAlreadyExistException;

public class UserValidator {
	static List<String> nameList = new ArrayList<>();

	private UserValidator() {

	}
/**
 * method to check user name already exist
 * @param searchName
 * @param errorMessage
 * @return
 * @throws NameAlreadyExistException
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public static boolean nameAlreadyExist(String searchName, String errorMessage)
			throws NameAlreadyExistException, ClassNotFoundException, SQLException {

		boolean isValidNumber = false;
		UserManagerDao manager = new UserManagerDao();
		nameList=manager.displayName();
	    for(String name:nameList)

		if (name.equals(searchName)){
			throw new NameAlreadyExistException(errorMessage);

		}else {
			isValidNumber = true;
		}
		return isValidNumber;

	}
}


