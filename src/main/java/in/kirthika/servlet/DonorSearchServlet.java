package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.exception.EmptyBloodGroupException;
import in.kirthika.service.DonorManager;
import in.kirthika.util.MobileNumberValidator;
import in.kirthika.validator.BloodGroupValidator;
import in.kirthika.validator.PlaceValidator;

/**
 * Servlet implementation class DonorSearchServlet
 */
@WebServlet("/DonorSearchServlet")
public class DonorSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String donorBlood=request.getParameter("bloodGroup");
	 String donorPlace=request.getParameter("place");
	 try {
		BloodGroupValidator.donorBloodGroupValidator(donorBlood,"Blood Group cannot be Empty");
		 PlaceValidator.donorPlaceValidator(donorPlace, "Invalid Place");
		 DonorManager manager=new DonorManager();
		 boolean valid=manager.donorSearch(donorBlood, donorPlace);
		 if(valid) {
			
		     response.sendRedirect("searchdonor.jsp");
		 }
		
		 
	} catch (Exception e) {
		response.sendRedirect("donorsearchpage.jsp?errorMessage=" + e.getMessage());
	}
	 
	
	 
    	
	
}


}
