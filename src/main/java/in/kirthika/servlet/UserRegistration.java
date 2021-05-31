package in.kirthika.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.kirthika.model.UserDetail;
import in.kirthika.service.UserManager;
import in.kirthika.util.MobileNumberValidator;
import in.kirthika.util.NameValidator;
import in.kirthika.util.PasswordValidator;


/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	final String ACTION="register.jsp?message=";
	try {
	    
    	String userName=request.getParameter("userName");
    	String userPassword=request.getParameter("password");
    	
    	Long userNumber=Long.parseLong(request.getParameter("mobileNumber"));
       
		
		NameValidator.isValidName(userName);
		PasswordValidator.isValidFormat(userPassword);
		
		MobileNumberValidator.isValidMobileNumber(userNumber);
	   
	    UserDetail user=new UserDetail(userName,userPassword,userNumber);
	    boolean valid=UserManager.addUser(user);
	    if(valid)
	    {  
	    	String message="Registration Successful";
	    	response.sendRedirect(ACTION +message);
	    }
	    else {
	    	String message="Registration Invalid";
	    	response.sendRedirect(ACTION +message);
	    }
	}
	catch(Exception e) {
		response.sendRedirect(ACTION + e.getMessage());
		
	}
}
}
