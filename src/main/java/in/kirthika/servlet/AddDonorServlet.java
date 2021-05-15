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
		PrintWriter out=response.getWriter();
		out.println("page content");
		
		String donorName=request.getParameter("donorName");
		String donorBlood=request.getParameter("bloodGroup");
		Long donorNumber=Long.parseLong(request.getParameter("mobileNumber"));
		Integer donorAge=Integer.parseInt(request.getParameter("age"));
		boolean valid=DonorManager.addDonor(donorBlood,donorName,donorNumber,donorAge);
		if(valid) 
		{
			String errorMessage="Donor already exist";
			response.sendRedirect("donordetails.jsp?errorMessage=" +errorMessage);
		}
		else
		{
			String infoMessage="Donor added";
			response.sendRedirect("donordetails.jsp?infoMessage=" +infoMessage);
		}
	
	}



}
