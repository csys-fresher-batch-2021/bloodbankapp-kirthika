package in.kirthika.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import in.kirthika.model.SeekerDetail;
import in.kirthika.util.ConnectionUtil;

public class SeekerManagerDao {
	private static final List<SeekerDetail> seekerList = new ArrayList<>();
    private static final String SEEKER_BLOOD ="seeker_blood";
	private static final String SEEKER_NAME ="seeker_name";
	private static final String SEEKER_MOBILENUMBER ="seeker_number";
	private static final String SEEKER_AGE ="seeker_age";
	private static final String SEEKER_PLACE ="seeker_place";
    private static final String SEEKER_DATE ="seeker_date";
	private static final String SEEKER_GENDER ="seeker_gender";
	private static final String SEEKER_STATUS="seeker_status";
	private static final String INSERT_SEEKER_DATA_QUERY ="insert into seeker_detail (seeker_blood,seeker_name,seeker_number,seeker_age,seeker_place,seeker_date,seeker_gender,seeker_status) values (?,?,?,?,?,?,?,?)";
	private static final String DISPLAY_ALL_DATA_QUERY="select * from seeker_detail where seeker_status='Pending'";
	private static final String UPDATE_SEEKER_DATA_QUERY="update seeker_detail set seeker_status='Approved' where seeker_number=?"; 
	
	 public boolean save(SeekerDetail detail) throws ClassNotFoundException, SQLException {
	    	boolean isValid=false;
	    	Connection connection=null;
	    	PreparedStatement pst=null;
	    	try{
	    		connection=ConnectionUtil.getConnection();
	    	    String sql=INSERT_SEEKER_DATA_QUERY;
	    	
	    	
	    	pst=connection.prepareStatement(sql);
	    	pst.setString(1,detail.getBloodGroup());
	    	pst.setString(2,detail.getName());
	    	pst.setLong(3,detail.getMobileNumber());
	    	pst.setInt(4,detail.getAge());
	    	pst.setString(5,detail.getPlace());
	    	pst.setObject(6,detail.getDate());
	    	pst.setString(7,detail.getGender());
	    	pst.setString(8,"Pending");
	    	pst.executeUpdate();
	    	}
	    	catch (ClassNotFoundException | SQLException e){
	    		isValid=true;
	    		e.getMessage();}
	    	finally {
	    	
	    	ConnectionUtil.close(pst,connection);
	    	}
	    	return isValid;
	    }
	 public static  List<SeekerDetail> displayAllList() throws ClassNotFoundException, SQLException
	    {  
		   seekerList.clear();
		   Connection connection=null; 
		   PreparedStatement pst=null;
		   try {
	    	   connection=ConnectionUtil.getConnection();
	    	
	    	String sql=DISPLAY_ALL_DATA_QUERY;
	    	
	    	 pst=connection.prepareStatement(sql);
	    	
	    	ResultSet rs=pst.executeQuery();
	    	 
	    	while(rs.next()) {
	    		String seekerBlood=rs.getString(SEEKER_BLOOD);
	    		String seekerName=rs.getString(SEEKER_NAME);
	    		Long seekerNumber=rs.getLong(SEEKER_MOBILENUMBER);
	    		int seekerAge=rs.getInt(SEEKER_AGE);
	    		String seekerPlace=rs.getString(SEEKER_PLACE);
	    		LocalDate seekerDate=LocalDate.parse(rs.getString(SEEKER_DATE));
	    		String seekerGender=rs.getString(SEEKER_GENDER);
	    		String seekerStatus=rs.getString(SEEKER_STATUS);
	    		
	    		
	    		SeekerDetail detail=new SeekerDetail(seekerBlood,seekerName,seekerNumber,seekerAge,seekerPlace,seekerDate,seekerGender,seekerStatus);
	    		seekerList.add(detail);
	    		System.out.println(seekerList);
	    		
	    		
	    		
	    	}
		   }
		   catch (ClassNotFoundException | SQLException e){
	   		e.getMessage();}
	   	finally {
		   
	    	ConnectionUtil.close(pst,connection);}
	    	return seekerList;
	    	
	    	
	    	
	    }
	 
	 public void approveSeeker(Long seekerNum) throws ClassNotFoundException, SQLException
	    {   Connection connection=null;
	        PreparedStatement pst=null;
	        
	    	try{
	    		
	    	connection=ConnectionUtil.getConnection();
	    	String sql=UPDATE_SEEKER_DATA_QUERY;
	    
	        pst=connection.prepareStatement(sql);
	        String num=String.valueOf(seekerNum);
	    	pst.setString(1, num);
	    	pst.executeUpdate();
	    	
	    	seekerList.clear();
	    	displayAllList();
	    	}
	    	catch (ClassNotFoundException | SQLException e){
	    		e.getMessage();}
	    	
	    	ConnectionUtil.close(pst,connection);
	    	
	    }

}


