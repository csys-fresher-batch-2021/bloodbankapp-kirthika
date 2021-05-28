package in.kirthika.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import in.kirthika.model.UserDetail;
import in.kirthika.util.ConnectionUtil;

public class UserManagerDao {
	private static final String INSERT_DONOR_DATA_QUERY ="insert into user_credential(username,userpassword,userbloodgroup,usermobilenumber,userage,userplace) values (?,?,?,?,?,?)";
	private static final String SEARCH_DONOR_DATA_QUERY="select * from user_credential where username=? and userpassword=?";
	private static final String USER_NAME ="username";
	private static final String USER_PASSWORD ="userpassword";
	private static final Map<String,String> userCredential=new HashMap<>();
	public boolean addUser(UserDetail user) throws ClassNotFoundException, SQLException {
	
		boolean isValid=true;
    	Connection connection=null;
    	PreparedStatement pst=null;
    	try{connection=ConnectionUtil.getConnection();
    	String sql=INSERT_DONOR_DATA_QUERY;
    	
    	
    	pst=connection.prepareStatement(sql);
    	pst.setString(1,user.getUserName());
    	pst.setString(2,user.getUserPassword());
    	pst.setString(3,user.getUserBloodGroup());
    	pst.setLong(4,user.getUserMobileNum());
    	pst.setInt(5,user.getUserAge());
    	pst.setString(6,user.getUserPlace());
    	pst.executeUpdate();
    	}
    	catch(Exception e) {
    		
    		isValid=false;
    		e.getMessage();
    	}
    	finally {
    		ConnectionUtil.close(pst,connection);
    	}
    	return isValid;
	}
	
	
	public Map<String,String> checkUserCredential(String userName,String userPassword) {
		
		
    	Connection connection=null;
    	PreparedStatement pst=null;
    	try{connection=ConnectionUtil.getConnection();
    	String sql=SEARCH_DONOR_DATA_QUERY;
    	
    	pst=connection.prepareStatement(sql);
    	pst.setString(1, userName );
    	pst.setString(2, userPassword );
    	
    	ResultSet rs=pst.executeQuery();
    	
    	
    	while(rs.next()) {
    		
    		String name=rs.getString(USER_NAME);
    		String password=rs.getString(USER_PASSWORD);
    		userCredential.put(name,password);
    	
            
    	}
    	}
    	catch (ClassNotFoundException | SQLException e){
    		e.getMessage();}
    	finally {
          ConnectionUtil.close(pst,connection);
    	        }
    	return userCredential ;
	}
	
	public Map<String,String> displayUserCredential()
	{
		return userCredential ;
	}

}
