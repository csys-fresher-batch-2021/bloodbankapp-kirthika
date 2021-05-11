package in.kirthika.service;

import java.util.ArrayList;
import java.util.List;

public class DonorDetails {
	public static List<DonorManager> taskList = new ArrayList<DonorManager>();
	   public static void donorAdd()
	   {
		DonorManager task1 = new DonorManager("B+","kirthika",7598002793L,21);		
		DonorManager task2 = new DonorManager ("O+","Swetha",7598002794L,23);
		DonorManager task3 = new DonorManager("A+","Ram",7598002765L,34);
		DonorManager task4 = new DonorManager("O+","ruby",9080052128L,27);
		//Store List of Tasks
		 
		{
			taskList.add(task1);
			taskList.add(task2);
			taskList.add(task3);
			taskList.add(task4);
			
			
		}
	   }
	   public static boolean displayDonor(String blood)
	   { boolean valid=false;
		 for(DonorManager detail:taskList)
		 {   
			 if(detail.bloodGroup.equalsIgnoreCase(blood))
			 {
				 System.out.println(detail);
				 valid=true;
			 }
			 
		 }
		 if(valid==false)
		 {
			 System.out.println("Details not available");
		 }
		
		 return valid;
	    }
}
	


