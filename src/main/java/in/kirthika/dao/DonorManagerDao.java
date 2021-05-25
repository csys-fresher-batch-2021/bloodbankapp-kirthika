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
    static {
    	try {
			displayAllList();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    
    public  void save(DonorDetail detail) throws ClassNotFoundException, SQLException {
    	
    	Connection connection=ConnectionUtil.getConnection();
    	
    
    	
    	String sql="insert into donor_detail (donor_blood,donor_name,donor_number,donor_age,donor_place) values (?,?,?,?,?)";
    	
    	
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
    	
    	String sql="select * from donor_detail";
    	
    	PreparedStatement pst=connection.prepareStatement(sql);
    	
    	ResultSet rs=pst.executeQuery();
    	
    	while(rs.next()) {
    		String donorBlood=rs.getString("donor_blood");
    		String donorName=rs.getString("donor_name");
    		Long donorNumber=rs.getLong("donor_number");
    		int donorAge=rs.getInt("donor_age");
    		String donorPlace=rs.getString("donor_place");
    		
    		DonorDetail detail=new DonorDetail(donorBlood,donorName,donorNumber,donorAge,donorPlace);
    		taskList.add(detail);
    		
    		
    	}
    	ConnectionUtil.close(connection);
    	return taskList;
    	
    	
    	
    }
    public List<DonorDetail> searchList(String donorBlood,String donorPlace) throws ClassNotFoundException, SQLException{
    	Connection connection=ConnectionUtil.getConnection();
    	donorSearch.clear();
    	String sql="select * from donor_detail where donor_blood=? and donor_place=?";
    	
    	PreparedStatement pst=connection.prepareStatement(sql);
    	pst.setString(1, donorBlood);
    	pst.setString(2, donorPlace);
    	
    	ResultSet rs=pst.executeQuery();
    	
    	while(rs.next()) {
    		
    		String donorBlood1=rs.getString("donor_blood");
    		String donorName=rs.getString("donor_name");
    		
    		Long donorNumber=rs.getLong("donor_number");
    		int donorAge=rs.getInt("donor_age");
    		String donorPlace1=rs.getString("donor_place");
    		

    		DonorDetail detail=new DonorDetail(donorBlood1,donorName,donorNumber,donorAge, donorPlace1);
    		donorSearch.add(detail);
    		
    		
    	}
    	ConnectionUtil.close(connection);
    	return donorSearch ;
    	
    }

    	
	
	public void deleteDonor(String donorName) throws ClassNotFoundException, SQLException
    {
    	Connection connection=ConnectionUtil.getConnection();
    	String sql="delete from donor_detail where donor_name=?";
    
    	PreparedStatement pst=connection.prepareStatement(sql);
    	pst.setString(1, donorName);
    	pst.executeUpdate();
    	
    	taskList.clear();
    	displayAllList();
    	
    	ConnectionUtil.close(connection);
    	
    }
    public List<DonorDetail> displayIndividual(String donorNum) throws ClassNotFoundException, SQLException
    {   
    	
    	Connection connection=ConnectionUtil.getConnection();
    	
    	String sql="select * from donor_detail where donor_number=?";
    	
    	PreparedStatement pst=connection.prepareStatement(sql);
    	pst.setString(1, donorNum);
    	
    	
    	ResultSet rs=pst.executeQuery();
    	
    	while(rs.next()) {
    		String donorBlood=rs.getString("donor_blood");
    		String donorName=rs.getString("donor_name");
    		Long donorNumber=rs.getLong("donor_number");
    		int donorAge=rs.getInt("donor_age");
    		String donorPlace=rs.getString("donor_place");
    		
    		DonorDetail detail=new DonorDetail(donorBlood,donorName,donorNumber,donorAge,donorPlace);
    		taskList.add(detail);
    		
    	}
    	ConnectionUtil.close(connection);
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
