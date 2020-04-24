package fuel_predictor_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	
	private UserValidation validateUser = new UserValidation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/views/Login1.jsp").forward(request,response);
		//request.getRequestDispatcher("/WEB-INF/Login1.jsp").forward(request,response);
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("pass");
		request.setAttribute("fname", ".");
		request.setAttribute("add1", ".");
		request.setAttribute("add2", ".");
		request.setAttribute("city", ".");
		request.setAttribute("state", ".");
		request.setAttribute("zip", ".");
		request.setAttribute("profile", "yes");
		request.setAttribute("User", name);
		this.getServletConfig().getServletContext().setAttribute("User", name);
		System.out.println("User from Login....... "+request.getAttribute("User"));
		request.setAttribute("gallons",0);
		int isUserValid = 0;

		try {
			isUserValid = validateUser.isValidUser(name, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isUserValid==2)
		{
			request.setAttribute("username", name);
			request.setAttribute("pass", password);
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
		}
		else if(isUserValid==1)
		{
			request.setAttribute("error", "Invalid Password");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/Login1.jsp").forward(request,response);
		}
		else if(isUserValid==0)
		{
			request.setAttribute("error", "Username Does'nt Exist");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/Login1.jsp").forward(request,response);
		}
		else if(isUserValid==-2)
		{
			request.setAttribute("username", name);
			request.setAttribute("pass", password);
			request.setAttribute("profile", "no");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/ProfileMgtNewUser.jsp").forward(request,response);
		}
		else if(isUserValid==-1)
		{
			request.setAttribute("error", "Database Connectivity Error");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/Login1.jsp").forward(request,response);
		}
	}  

}
