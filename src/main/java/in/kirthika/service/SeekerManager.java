package in.kirthika.service;

import java.sql.SQLException;
import java.util.List;
import in.kirthika.dao.SeekerManagerDao;
import in.kirthika.model.SeekerDetail;
import in.kirthika.model.SeekerStatusDetail;

public class SeekerManager {

	private static SeekerManagerDao managerDao = new SeekerManagerDao();
	/**
	 * 
	 * @param seeker
	 * @return
	 */
	public boolean addSeeker(SeekerDetail seeker) {

		boolean valid = false;
		try {
			valid = managerDao.save(seeker);
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}

		return valid;
	}
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<SeekerDetail> displaySeekerList() throws ClassNotFoundException, SQLException {
		return (managerDao.displayAllList());
	}
	/**
	 * 
	 * @param donorNum
	 * @param name
	 */
	public void approveSeeker(Long donorNum, String name) {
		try {
			managerDao.approveSeeker(donorNum, name);
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		}
	}
	/**
	 * 
	 * @param detail
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean seekerStatus(SeekerDetail detail) throws ClassNotFoundException, SQLException {
		return (managerDao.seekerStatus(detail));
	}
	/**
	 * 
	 * @return
	 */
	public List<SeekerStatusDetail> displayDonor() {

		return (managerDao.display());
	}

}
