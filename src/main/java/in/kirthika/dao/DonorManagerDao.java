package in.kirthika.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.kirthika.model.DonorDetail;
import in.kirthika.util.ConnectionUtil;

public class DonorManagerDao {

	private static final List<DonorDetail> taskList = new ArrayList<>();
    private static final List<DonorDetail> donorSearch= new ArrayList<>();
    private static final String DONOR_BLOOD ="donor_blood";
	private static final String DONOR_NAME ="donor_name";
	private static final String DONOR_MOBILENUMBER ="donor_number";
	private static final String DONOR_AGE ="donor_age";
	private static final String DONOR_PLACE ="donor_place";
	private static final String INSERT_DONOR_DATA_QUERY ="insert into donor_detail (donor_blood,donor_name,donor_number,donor_age,donor_place) values (?,?,?,?,?)";
	private static final String DISPLAY_ALL_DATA_QUERY="select * from donor_detail";
	private static final String SEARCH_DONOR_DATA_QUERY="select * from donor_detail where donor_blood=? and donor_place=?";
	private static final String DELETE_DONOR_DATA_QUERY="delete from donor_detail where donor_name=?";
	private static final String DISPLAY_INDIVIDUAL_DATA_QUERY="select * from donor_detail where donor_number=?";
    static {
    	try {
			displayAllList();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.getMessage();
		}
    }
    
    
    public  void save(DonorDetail detail) throws ClassNotFoundException, SQLException {
    	
    	Connection connection=ConnectionUtil.getConnection();
    	String sql=INSERT_DONOR_DATA_QUERY;
    	
    	
    	PreparedStatement pst=connection.prepareStatement(sql);
    	pst.setString(1,detail.getBloodGroup());
    	pst.setString(2,detail.getName());
    	pst.setLong(3,detail.getMobileNumber());
    	pst.setInt(4,detail.getAge());
    	pst.setString(5,detail.getPlace());
    	pst.executeUpdate();
    	
    	
    	
    	ConnectionUtil.close(connection);
    	
    	
    }
   public static List<DonorDetail> displayAllList() throws ClassNotFoundException, SQLException
    {   
    	
    	Connection connection=ConnectionUtil.getConnection();
    	
    	String sql=DISPLAY_ALL_DATA_QUERY;
    	
    	PreparedStatement pst=connection.prepareStatement(sql);
    	
    	ResultSet rs=pst.executeQuery();
    	
    	while(rs.next()) {
    		String donorBlood=rs.getString(DONOR_BLOOD);
    		String donorName=rs.getString(DONOR_NAME);
    		Long donorNumber=rs.getLong(DONOR_MOBILENUMBER);
    		int donorAge=rs.getInt(DONOR_AGE);
    		String donorPlace=rs.getString(DONOR_PLACE);
    		
    		DonorDetail detail=new DonorDetail(donorBlood,donorName,donorNumber,donorAge,donorPlace);
    		taskList.add(detail);
    		
    		
    	}
    	ConnectionUtil.close(connection);
    	return taskList;
    	
    	
    	
    }
    public List<DonorDetail> searchList(String donorBlood,String donorPlace) throws ClassNotFoundException, SQLException{
    	Connection connection=null;
    	try{connection=ConnectionUtil.getConnection();
    	donorSearch.clear();
    	String sql=SEARCH_DONOR_DATA_QUERY;
    	
    	PreparedStatement pst=connection.prepareStatement(sql);
    	pst.setString(1, donorBlood);
    	pst.setString(2, donorPlace);
    	
    	ResultSet rs=pst.executeQuery();
    	
    	while(rs.next()) {
    		
    		String donorBlood1=rs.getString(DONOR_BLOOD);
    		String donorName=rs.getString(DONOR_NAME);
            Long donorNumber=rs.getLong(DONOR_MOBILENUMBER);
    		int donorAge=rs.getInt(DONOR_AGE);
    		String donorPlace1=rs.getString(DONOR_PLACE);
    		

    		DonorDetail detail=new DonorDetail(donorBlood1,donorName,donorNumber,donorAge, donorPlace1);
    		donorSearch.add(detail);}
    	}
    	catch (ClassNotFoundException | SQLException e){
    		e.getMessage();}
    	finally {
          ConnectionUtil.close(connection);
    	        }
    	return donorSearch ;
    }

    	
	
	public void deleteDonor(String donorName) throws ClassNotFoundException, SQLException
    {   Connection connection=null;
      
    	try{
    	connection=ConnectionUtil.getConnection();
    	String sql=DELETE_DONOR_DATA_QUERY;
    
        PreparedStatement pst=connection.prepareStatement(sql);
    	pst.setString(1, donorName);
    	pst.executeUpdate();
    	
    	taskList.clear();
    	displayAllList();
    	}
    	catch (ClassNotFoundException | SQLException e){
    		e.getMessage();}
    	
    	ConnectionUtil.close(connection);
    	
    }
    public List<DonorDetail> displayIndividual(String donorNum) throws ClassNotFoundException, SQLException
    {   Connection connection=null;
    try {
    	
    	 connection=ConnectionUtil.getConnection();
    	
    	String sql=DISPLAY_INDIVIDUAL_DATA_QUERY;
    	
    	PreparedStatement pst=connection.prepareStatement(sql);
    	pst.setString(1, donorNum);
    	
    	
    	ResultSet rs=pst.executeQuery();
    	
    	while(rs.next()) {
    		String donorBlood=rs.getString(DONOR_BLOOD);
    		String donorName=rs.getString(DONOR_NAME);
    		Long donorNumber=rs.getLong(DONOR_MOBILENUMBER);
    		int donorAge=rs.getInt(DONOR_AGE);
    		String donorPlace=rs.getString(DONOR_PLACE);
    		
    		DonorDetail detail=new DonorDetail(donorBlood,donorName,donorNumber,donorAge,donorPlace);
    		taskList.add(detail);
    	}
    }
    	catch(ClassNotFoundException | SQLException e){
    		e.getMessage();}
    	
    	finally {	
    	
    	ConnectionUtil.close(connection);
    	}
    	return taskList;
    	
    }
    
    public List<DonorDetail> allDonorList()
    {
    	return taskList;
    }
    public List<DonorDetail> allSearchDonorList()
    {
    	return donorSearch;
    }
    
   
}
