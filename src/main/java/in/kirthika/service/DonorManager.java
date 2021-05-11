package in.kirthika.service;

import java.util.ArrayList;
import java.util.List;

public class DonorManager {
	private void DonoManager()
	{
		//default constructor
	}
	private static final List<DonorDetail> taskList = new ArrayList<>();
	   static
	   {
		DonorDetail task1 = new DonorDetail("B+","kirthika",7598002793L,21);		
		DonorDetail task2 = new DonorDetail ("O+","Swetha",7598002794L,23);
		DonorDetail task3 = new DonorDetail("A+","Ram",7598002765L,34);
		DonorDetail task4 = new DonorDetail("O+","ruby",9080052128L,27);
		//Store List of Tasks
		 
	
			taskList.add(task1);
			taskList.add(task2);
			taskList.add(task3);
			taskList.add(task4);
	}
	   public static boolean displayDonor(String name)
	   { boolean valid=false;
		 for(DonorDetail detail:taskList)
		 {   
			 if(detail.getName().equalsIgnoreCase(name))
			 {
				 System.out.println(detail);
				 valid=true;
			 }
			 
		 }
		
		 return valid;
	    }
	   public static List<DonorDetail> displayDonor()
	   {   
		   return taskList;
	   }
	   
}
	


