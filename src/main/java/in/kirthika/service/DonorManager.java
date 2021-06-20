package in.kirthika.service;

import in.kirthika.dao.DonorManagerDao;
import in.kirthika.model.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DonorManager {

	private DonorManagerDao managerDao = new DonorManagerDao();
	/**
	 * 
	 * @param detail
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public boolean addDonor(DonorDetail detail) throws ClassNotFoundException, SQLException {

		boolean isValid = managerDao.save(detail);
		if (!isValid) {
			managerDao.displayIndividual(String.valueOf(detail.getMobileNumber()), detail.getName());
		}
		return isValid;
	}
	/**
	 * 
	 * @param donorNum
	 * @param donorName
	 */

	public void deleteDonor(Long donorNum, String donorName) {
		try {

			managerDao.deleteDonor(donorNum, donorName);
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
	}
    /**
     * 
     * @param donorBlood
     * @param donorPlace
     * @return
     */
	public boolean donorSearch(String donorBlood, String donorPlace) {
		boolean isValid = true;
		try {
			managerDao.searchList(donorBlood, donorPlace);
		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
			isValid = false;
		}
		return isValid;
	}
    /**
     * 
     * @param blood
     */
	public void filterBlood(String blood) {
		try {
			managerDao.filterBlood(blood);

		} catch (ClassNotFoundException | SQLException e) {

			e.getMessage();
		}
	}
	/**
	 * 
	 * @param name
	 * @param mode
	 */
	public void sleepStatus(String name,String mode) {
		
		managerDao.setStatus(name,mode);
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	public String status(String name) {
		String status=managerDao.getStatus(name);
		return status;
	}
	/**
	 * 
	 * @param detail
	 * @return
	 */
	public Map<String,Integer> stockCount(DonorDetail detail) {
		return(managerDao.stockCount(detail));
		
	}
    /**
     * 
     * @return
     */
	public List<DonorDetail> displayDonorList() {
		return (managerDao.allDonorList());
	}
    /**
     * 
     * @return
     */
	public List<DonorDetail> displaySearchDonorList() {
		return (managerDao.allSearchDonorList());
	}
    /**
     * 
     * @return
     */
	public List<DonorDetail> filterList() {
		return (managerDao.displayFilterList());
	}
	/**
	 * 
	 * @return
	 */
	public Map<String,Integer> stockList(){
		return(managerDao.stockList());
	}

	


}
