package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.kirthika.model.SeekerDetail;
import in.kirthika.service.SeekerManager;

import in.kirthika.util.NameValidator;
import in.kirthika.validator.SeekerValidator;

/**
 * Servlet implementation class SeekerStatus
 */
@WebServlet("/SeekerStatus")
public class SeekerStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("seekerName");
		
		try {
			Long donorNumber=Long.parseLong(request.getParameter("mobileNumber"));
			NameValidator.isValidName(name);
			SeekerValidator.seekerNumberValidator(donorNumber,"Seeker not Registered");
		    SeekerDetail detail=new SeekerDetail();
		    detail.setName(name);
		    detail.setMobileNumber(donorNumber);
		    SeekerManager manager=new SeekerManager();
		    boolean isValid=manager.seekerStatus(detail);
		   
		    	if(isValid)
		    	{
		    		String status="Approved";
		    		response.sendRedirect("statusdisplay.jsp?name="+name+"&number="+donorNumber+"&status="+status);
		    	}
		    	else
		    	{
		    		String status="Pending";
		    		response.sendRedirect("statusdisplay.jsp?name="+name+"&number="+donorNumber+"&status="+status);
		    	}
			}
		catch(Exception e) {
			response.sendRedirect("seekerstatus.jsp?errorMessage=" + e.getMessage());
			
		}

	}

}
