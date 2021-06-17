package in.kirthika.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;

/**
 * Servlet implementation class SleepStatusServlet
 */
@WebServlet("/SleepStatusServlet")
public class SleepStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		String name=request.getParameter("userName");
	
		DonorDetail detail = new DonorDetail();
		detail.setUserName(name);
		DonorManager manager = new DonorManager();
		String status=manager.status(name);
	    PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(status);
		out.print(json);
		out.flush();

}
}
