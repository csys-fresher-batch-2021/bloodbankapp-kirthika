package in.kirthika.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.kirthika.service.UserManager;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("password");
		{
			boolean isValid=UserManager.userCheck(userName,userPassword);
			if(isValid)
			{  
				HttpSession session=request.getSession();
				session.setAttribute("LOGIN_USER", userName);
				response.sendRedirect("adminmanager.jsp");
			}
			else
			{
				String errorMessage="Invalid Credentials";
				response.sendRedirect("userregistration.jsp?message="+errorMessage);
			}
		}
		
}
}
