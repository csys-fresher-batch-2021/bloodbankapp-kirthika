package in.kirthika.service;

import in.kirthika.dao.DonorManagerDao;
import in.kirthika.model.*;

import java.sql.SQLException;

import java.util.List;




public class DonorManager {
	
	
	private DonorManagerDao managerDao=new DonorManagerDao();
	 
	   public boolean addDonor(String donorBlood,String donorName,Long donorNumber,int donorAge,String donorPlace) throws ClassNotFoundException, SQLException
	   {    DonorDetail task=new DonorDetail(donorBlood,donorName,donorNumber,donorAge,donorPlace);
	      
	      
				boolean isValid=managerDao.save(task);
				
				if(!isValid) {
				managerDao.displayIndividual(String.valueOf(donorNumber),donorName);}
			    return isValid;
			
	 }
	  
	   public void deleteDonor(Long donorNum,String donorName) {
		   try {
			  
			    managerDao.deleteDonor(donorNum,donorName);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.getMessage();
		}
	   }
	   
	   public boolean donorSearch(String donorBlood,String donorPlace)
	   {   boolean isValid=true;
		   try {
			managerDao.searchList(donorBlood, donorPlace);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.getMessage();
			isValid=false;
		} 
		   return isValid;
	   }
	  public void filterBlood(String blood)
	  {
		  try {
			managerDao.filterBlood(blood);
	
		} catch (ClassNotFoundException | SQLException e) {
		
			e.getMessage();
		}
	  }
	  public List<DonorDetail> displayDonorList()
	  {
		  return(managerDao.allDonorList());
	  }
	  
	  public List<DonorDetail> displaySearchDonorList()
	  {
		  return(managerDao.allSearchDonorList());
	  }
	  public List<DonorDetail>  filterList()
	  {   
		  return(managerDao.displayFilterList());
	  }
	
	
}



