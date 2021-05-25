package in.kirthika.service;

import in.kirthika.dao.DonorManagerDao;
import in.kirthika.model.*;

import java.sql.SQLException;


public class DonorManager {
	
	
	private DonorManagerDao managerDao=new DonorManagerDao();
	   
	   public boolean addDonor(String donorBlood,String donorName,Long donorNumber,int donorAge,String donorPlace)
	   {   boolean isValid=false; 
	      DonorDetail task=new DonorDetail(donorBlood,donorName,donorNumber,donorAge,donorPlace);
	      try {
				managerDao.save(task);
				managerDao.displayIndividual(String.valueOf(donorNumber));
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.getMessage());
				isValid=true;
			}
	      return isValid;
	 }
	   public void deleteDonor(String donorName) {
		   try {
			  
			    managerDao.deleteDonor(donorName);
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e.getMessage());
		}
	   }
	   
	   public void donorSearch(String donorBlood,String donorPlace)
	   {
		   try {
			managerDao.searchList(donorBlood, donorPlace);
		} catch (ClassNotFoundException | SQLException e) {
		
			System.out.println(e.getMessage());
		} 
	   }
	
}



