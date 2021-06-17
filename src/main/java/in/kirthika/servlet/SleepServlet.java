package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class SleepServlet
 */
@WebServlet("/SleepServlet")
public class SleepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String name=request.getParameter("name");
		String mode=request.getParameter("clicked");
		DonorDetail detail = new DonorDetail();
		detail.setUserName(name);
		detail.setStatus(mode);
		DonorManager manager = new DonorManager();
		manager.sleepStatus(name,mode);

		
}
}
