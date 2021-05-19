package in.kirthika.service;

public class AdminManager {
	
	public static boolean userCheck(String userName,String userPassword)
	{    boolean isValid=false;
		if(userName.equalsIgnoreCase("admin")&& userPassword.equalsIgnoreCase("welcome"))
          {
	            isValid=true;
          }
		return isValid;
	}

}
