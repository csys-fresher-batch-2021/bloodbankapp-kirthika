package in.kirthika.service;

public class AdminManager {
	private AdminManager() {
		// default constructor
	}
    /**
     * 
     * @param userName
     * @param userPassword
     * @return
     */
	public static boolean adminCheck(String userName, String userPassword) {
		boolean isValid = false;
		if (userName.equalsIgnoreCase("admin") && userPassword.equalsIgnoreCase("welcome")) {
			isValid = true;
		}
		return isValid;
	}

}
