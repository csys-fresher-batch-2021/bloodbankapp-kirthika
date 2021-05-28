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
import com.google.gson.JsonObject;

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
@WebServlet("/AddDonorServlet1")
public class AddDonorServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		  String donorName=request.getParameter("donorName"); 
		  String donorBlood=request.getParameter("bloodGroup"); 
		  Long donorNumber=Long.parseLong(request.getParameter("mobileNumber")); 
		  Integer donorAge=Integer.parseInt(request.getParameter("age")); String
		  donorPlace=request.getParameter("place");
		 
		try {
			
			NameValidator.isValidName(donorName);
			BloodGroupValidator.donorBloodGroupValidator(donorBlood,"Blood Group cannot be Empty");
			MobileNumberValidator.isValidMobileNumber(donorNumber);
			AgeValidator.isEligibleDonor(donorAge,"Invalid Age for Donor");
		    PlaceValidator.donorPlaceValidator(donorPlace, "Invalid Place");
		  
		    DonorManager manager=new DonorManager();
		    boolean valid=manager.addDonor(donorBlood,donorName,donorNumber,donorAge,donorPlace);
		   
		   
			
			 List<DonorDetail> list=manager.displayDonorList(); 
			 //Gson gson=new Gson();
			//String json=gson.toJson(list); 
			 //System.out.println(json);
			 
		    PrintWriter out=response.getWriter();
		    out.print(valid);
		    out.flush();
			/*
			 * JsonObject object = new JsonObject(); object.addProperty("infoMessage",
			 * "Successfully Added"); out.println(object);
			 */
		   
		    
		if(valid) 
		{
			String errorMessage="Donor already exist";
			System.out.println(errorMessage);
		}
		
	}
		catch (Exception e) 
		{
			
			 e.getMessage();
		}
		
}
}

		

