package in.kirthika.service;
import java.sql.SQLException;
import java.util.List;
import in.kirthika.dao.SeekerManagerDao;
import in.kirthika.exception.NotRegisteredException;
import in.kirthika.model.SeekerDetail;
import in.kirthika.model.SeekerStatusDetail;

public class SeekerManager {

	private SeekerManagerDao managerDao=new SeekerManagerDao();
	public boolean addSeeker(SeekerDetail seeker)
	{
	   
	    boolean valid=false;
		try {
			valid = managerDao.save(seeker);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.getMessage();
		}
	    
	    return valid;
	}
	  public List<SeekerDetail> displaySeekerList() throws ClassNotFoundException, SQLException
	  {
		  return(managerDao.displayAllList());
	  }
	  
	  public void approveSeeker(Long donorNum) {
		   try {
			  
			    managerDao.approveSeeker(donorNum);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.getMessage();
		}
	   }
	  public boolean seekerStatus(SeekerDetail detail) throws ClassNotFoundException, SQLException	  {   
		  return(managerDao.seekerStatus(detail));
	  }
	  public List<SeekerStatusDetail> displayDonor(){
		  
		  return(managerDao.display());
	  }

}
