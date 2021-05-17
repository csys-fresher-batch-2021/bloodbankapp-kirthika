package in.kirthika.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class DeleteDonorServlet
 */
@WebServlet("/DeleteDonorServlet")
public class DeleteDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String donorName=request.getParameter("donorName");
	    DonorManager.deleteDonor(donorName);
	    response.sendRedirect("donordetails.jsp");
		
	    
}
}
