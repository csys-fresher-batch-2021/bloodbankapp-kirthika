package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class DonorSearchServlet
 */
@WebServlet("/DonorSearchServlet")
public class DonorSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String donorBlood=request.getParameter("bloodGroup");
    	 String donorPlace=request.getParameter("place");
    	 DonorManager.donorSearch(donorBlood, donorPlace);
    	 response.sendRedirect("searchdonor.jsp");
	
	}


}
