package in.kirthika.validator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.kirthika.dao.SeekerManagerDao;
import in.kirthika.exception.NotRegisteredException;

public class SeekerValidator {


	private SeekerValidator() {
		
	}
	public static boolean seekerNumberValidator(Long number, String errorMessage)throws NotRegisteredException, ClassNotFoundException, SQLException {
		List<Long> numberList=new ArrayList<>();
		boolean isValidNumber = false;
		SeekerManagerDao manager=new SeekerManagerDao();
		numberList=manager.seekerNumber();
		for(Long seeker:numberList) {
			if(seeker.equals(number)) {
				isValidNumber=true;
				break;
			}
		}
			if(!isValidNumber)
			{
		       throw new NotRegisteredException(errorMessage);
			}
			return isValidNumber;
		}
		
	}

