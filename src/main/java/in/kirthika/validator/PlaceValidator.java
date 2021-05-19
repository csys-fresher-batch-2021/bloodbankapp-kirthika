package in.kirthika.validator;

import in.kirthika.exception.InvalidPlaceException;

public class PlaceValidator {
	private PlaceValidator()
	{
		//default constructor
	}
	public static boolean DonorPlaceValidator(String place, String errorMessage) 
			throws InvalidPlaceException
	{
		if(place==null || place.trim().isEmpty()||place.trim().length()<=5)
		{
			throw new InvalidPlaceException(errorMessage);
		}
		return true;
	}

}
