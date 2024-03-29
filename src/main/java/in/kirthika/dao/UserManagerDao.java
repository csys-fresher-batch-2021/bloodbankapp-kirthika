package in.kirthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import in.kirthika.model.UserDetail;
import in.kirthika.util.ConnectionUtil;

public class UserManagerDao {
	private static final String INSERT_DONOR_DATA_QUERY = "insert into user_credential(username,userpassword,usermobilenumber) values (?,?,?)";
	private static final String SEARCH_DONOR_DATA_QUERY = "select * from user_credential where username=? and userpassword=?";
	private static final String ALL_USER_NAME="select username from user_credential";
	private static final String USER_NAME = "username";
	private static final String USER_PASSWORD = "userpassword";
	private static final Map<String, String> userCredential = new HashMap<>();
	private static final List<String> userName=new ArrayList<>();

	public boolean addUser(UserDetail user) throws ClassNotFoundException, SQLException {
		/*
		 * function to add user credential to the database
		 */
		boolean isValid = true;
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = INSERT_DONOR_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserPassword());
			pst.setLong(3, user.getUserMobileNum());

			pst.executeUpdate();
		} catch (Exception e) {
			isValid = false;
			
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isValid;
	}
	/**
	 * function to check valid credentials
	 * @param userName
	 * @param userPassword
	 * @return
	 */

	public Map<String, String> checkUserCredential(String userName, String userPassword) {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = SEARCH_DONOR_DATA_QUERY;

			pst = connection.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, userPassword);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String name = rs.getString(USER_NAME);
				String password = rs.getString(USER_PASSWORD);
				userCredential.put(name, password);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userCredential;
	}
	/**
	 * method to display all username
	 * @return
	 */
	public List<String> displayName(){
		Connection connection = null;
		PreparedStatement pst = null;
		userName.clear();
		try {
			
		connection = ConnectionUtil.getConnection();
		String sql = ALL_USER_NAME;
		pst = connection.prepareStatement(sql);
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			String	name = rs.getString(USER_NAME);
				userName.add(name);
		} 
		}catch (Exception e) {
				
				e.printStackTrace();
			} 
		finally {
			ConnectionUtil.close(pst, connection);
		}
			return userName;
			
		}
		
	public Map<String, String> displayUserCredential() {
		return userCredential;
	}

}