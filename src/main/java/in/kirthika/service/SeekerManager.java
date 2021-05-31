package in.kirthika.service;
import java.sql.SQLException;
import java.util.List;
import in.kirthika.dao.SeekerManagerDao;
import in.kirthika.model.SeekerDetail;

public class SeekerManager {
	private SeekerManagerDao managerDao=new SeekerManagerDao();
	public boolean addSeeker(SeekerDetail seeker)
	{
	    SeekerManagerDao detail=new SeekerManagerDao();
	    boolean valid=false;
		try {
			valid = detail.save(seeker);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.getMessage();
		}
	    
	    return valid;
	}
	  public List<SeekerDetail> displaySeekerList() throws ClassNotFoundException, SQLException
	  {
		  return(SeekerManagerDao.displayAllList());
	  }
	  
	  public void approveSeeker(Long donorNum) {
		   try {
			  
			    managerDao.approveSeeker(donorNum);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.getMessage();
		}
	   }

}
