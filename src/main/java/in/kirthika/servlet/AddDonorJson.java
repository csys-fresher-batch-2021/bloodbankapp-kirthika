package in.kirthika.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import in.kirthika.exception.InvalidNameException;
import in.kirthika.model.DonorDetail;
import in.kirthika.service.DonorManager;
import in.kirthika.util.MobileNumberValidator;
import in.kirthika.util.NameValidator;
import in.kirthika.validator.AgeValidator;
import in.kirthika.validator.BloodGroupValidator;
import in.kirthika.validator.DonorValidator;
import in.kirthika.validator.PlaceValidator;

/**
 * Servlet implementation class AddDonorJson
 */
@WebServlet("/AddDonorJson")
public class AddDonorJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			DonorDetail detail = new DonorDetail();
			String donorName = request.getParameter("donorName");
			String donorBlood = request.getParameter("donorBlood");
			Long donorNumber = Long.parseLong(request.getParameter("donorNumber"));
			Integer donorAge = Integer.parseInt(request.getParameter("donorAge"));
			String donorPlace = request.getParameter("donorPlace");

			NameValidator.isValidName(donorName);
			DonorValidator.isAlreadyExist(donorName, donorNumber, "Donor Already Exist");
			BloodGroupValidator.donorBloodGroupValidator(donorBlood, "Blood Group cannot be Empty");
			MobileNumberValidator.isValidMobileNumber(donorNumber);
			AgeValidator.isEligibleDonor(donorAge, "Invalid Age for Donor");
			PlaceValidator.donorPlaceValidator(donorPlace, "Invalid Place");

			detail.setName(donorName);
			detail.setBloodGroup(donorBlood);
			detail.setMobileNumber(donorNumber);
			detail.setAge(donorAge);
			detail.setPlace(donorPlace);

			DonorManager manager = new DonorManager();
			boolean valid = manager.addDonor(detail);
			// List<DonorDetail> donorList=manager.displayDonorList();
			JsonObject object = new JsonObject();
			if (valid) {
				object.addProperty("infoMessage", "Donor exist");
				out.println(object);
			}

			else {
				object.addProperty("infoMessage", "Donor added");
				out.println(object);
			}

			// Gson gson=new Gson();
			// String json=gson.toJson(donorList);
			// out.print(json);
			// out.flush();

		} catch (Exception e) {
			e.printStackTrace();
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);

		}
		out.flush();

	}
}
