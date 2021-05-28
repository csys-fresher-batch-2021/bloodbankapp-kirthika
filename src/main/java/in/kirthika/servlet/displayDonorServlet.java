package in.kirthika.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;
import in.kirthika.util.MobileNumberValidator;
import in.kirthika.util.NameValidator;
import in.kirthika.validator.AgeValidator;
import in.kirthika.validator.BloodGroupValidator;
import in.kirthika.validator.PlaceValidator;

/**
 * Servlet implementation class AddDonorServlet
 */
@WebServlet("/displayDonorServlet")
public class displayDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	DonorManager manager=new DonorManager();
    List<DonorDetail> list=manager.displayDonorList();
    Gson gson=new Gson();
    String json=gson.toJson(list);
    System.out.println(json);
    
    PrintWriter out=response.getWriter();
    out.print(json);
    out.flush();
   
	
}
}
	    