package in.kirthika.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class AddDonorServlet
 */
@WebServlet("/AddDonorServlet")
public class AddDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String donorName=request.getParameter("donorName");
		String donorBlood=request.getParameter("bloodGroup");
		Long donorNumber=Long.parseLong(request.getParameter("mobileNumber"));
		Integer donorAge=Integer.parseInt(request.getParameter("age"));
		String donorPlace=request.getParameter("place");
		boolean valid=DonorManager.addDonor(donorBlood,donorName,donorNumber,donorAge,donorPlace);
		if(valid) 
		{
			String errorMessage="Donor already exist";
			response.sendRedirect("adddonor.jsp?errorMessage=" +errorMessage);
			
		}
		else
		{
			response.sendRedirect("donordetails.jsp");
		}
	
	}



}
