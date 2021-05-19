package in.kirthika.validator;

import in.kirthika.exception.EmptyBloodGroupException;

public class BloodGroupValidator {
  
	public static boolean donorBloodGroupValidator(String bloodGroup, String errorMessage)
	     throws EmptyBloodGroupException
	{
		if(bloodGroup.length()!=2)
		{
			throw new EmptyBloodGroupException(errorMessage);
		}
		return true;
	}
}
