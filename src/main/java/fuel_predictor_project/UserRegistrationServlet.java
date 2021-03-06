package fuel_predictor_project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/registration.do")
public class UserRegistrationServlet extends HttpServlet {

	
	private NewUserValidation validateNewUser = new NewUserValidation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/views/ClientRegistration.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("pass");
		request.setAttribute("profile", "no");
		String confirmpassword = request.getParameter("cpass");
		request.setAttribute("fname", " ");
		request.setAttribute("add1", " ");
		request.setAttribute("add2", " ");
		request.setAttribute("city", " ");
		request.setAttribute("state", " ");
		request.setAttribute("zip", " ");
		int passCheck = validateNewUser.passwordCheck(password, confirmpassword);
		int isUserValid = validateNewUser.newUserValidation1(name);
		if(isUserValid == 1 && passCheck==1)
		{
			int nUser = validateNewUser.createNewUser(name,password);
			if(nUser == 0)
			{
				request.setAttribute("error", "Database Connectivity Issue, Please try again");
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/ClientRegistration.jsp").forward(request,response);
			}
			else if(nUser == 1)
			{
				request.setAttribute("username", name);
				request.setAttribute("User", name);
				this.getServletConfig().getServletContext().setAttribute("User", name);
				//response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/ProfileMgtNewUser.jsp").forward(request,response);
			}
			
		}
		else if(isUserValid == 0)
		{
			request.setAttribute("error", "Username Already Exists, Please Select a new Username");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/ClientRegistration.jsp").forward(request,response);
		}
		else if(isUserValid == -1)
		{
			request.setAttribute("error", "Database Coonectivity Issue");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/ClientRegistration.jsp").forward(request,response);
		}
		else if(passCheck == 0)
		{
			request.setAttribute("error", "Password and Confirm Password Fields Does'nt match");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/ClientRegistration.jsp").forward(request,response);
		}
		else if(passCheck == -1)
		{
			request.setAttribute("error", "Password Length is less than 8");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/ClientRegistration.jsp").forward(request,response);
		}
		else if(passCheck == -2)
		{
			request.setAttribute("error", "Password Contains symbols other than alphabets or digits");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/ClientRegistration.jsp").forward(request,response);
		}
		
	}  
}
