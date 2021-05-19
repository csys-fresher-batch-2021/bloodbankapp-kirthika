package in.kirthika.service;

import in.kirthika.model.*;
import java.util.ArrayList;
import java.util.List;

public class DonorManager {
	private DonorManager()
	{
		//default constructor
	}
	
	private static final List<DonorDetail> taskList = new ArrayList<>();
	private static final List<DonorDetail> donorSearch= new ArrayList<>();
	   static
	   {
		DonorDetail task1 = new DonorDetail("B+","kirthika",7598002793L,21,"trichy");		
		DonorDetail task2 = new DonorDetail ("O+","Swetha",7598002794L,23,"chennai");
		DonorDetail task3 = new DonorDetail("A+","Ram",7598002765L,34,"madurai");
		DonorDetail task4 = new DonorDetail("O+","ruby",9080052128L,27,"trichy");
		//Store List of Tasks
		 
	
			taskList.add(task1);
			taskList.add(task2);
			taskList.add(task3);
			taskList.add(task4);
	}
	
		
      /**
       * 
       * @param donorBlood
       * @param donorName
       * @param donorNumber
       * @param donorAge
       * @return
       */
	   public static boolean addDonor(String donorBlood,String donorName,Long donorNumber,int donorAge,String donorPlace)
	   {     
		   boolean valid=false;
		       for(DonorDetail number:taskList)
		       {   
		    	   if(number.getMobileNumber().equals(donorNumber))
		    	   {
		    		   valid=true;
		    	   }
		       }
		       if(!valid)
		       {
		    	   taskList.add(new DonorDetail(donorBlood,donorName,donorNumber,donorAge,donorPlace));
		       }
		    return valid;  
			 
	}
	   /**
	    * 
	    * @param donorName
	    */
	   public static void deleteDonor(String donorName)
	   {   
		  
		   int index=0;
		   for(DonorDetail name:taskList )
		   {
			   if(name.getName().equals(donorName))
			   {   
				
				   index=taskList.indexOf(name);
				   break;
			   }
		   }
		   taskList.remove(index);
		  
	   }
	   /**
	    * 
	    * @param donorBlood
	    * @param donorPlace
	    */
	   public static void donorSearch(String donorBlood,String donorPlace)
	   {   donorSearch.clear();
		   for(DonorDetail detail:taskList)
		   {
			   if(detail.getBloodGroup().equals(donorBlood) && detail.getPlace().equalsIgnoreCase(donorPlace))
			   {
				   
				   donorSearch.add(detail);
			   }
		   }
	   }
	/**
	 *   
	 * @return
	 */
	   public static List<DonorDetail> displaySearchDonor() 
	   {
		   return donorSearch;
	   }
	   
       
/**
 * 
 * @return
 */
	   public static List<DonorDetail> displayDonor()
	   {   
		   return taskList;
	   }

}
	


