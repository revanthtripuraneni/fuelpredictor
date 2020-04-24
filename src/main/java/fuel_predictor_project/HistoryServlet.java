package fuel_predictor_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/History.do")
public class HistoryServlet extends HttpServlet {
	//private QuoteHistoryServlet history = new QuoteHistoryServlet();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
		//request.getRequestDispatcher("/WEB-INF/Login1.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		PrintWriter writer = response.getWriter();
		String action = "";
		action = request.getParameter("action");
		request.setAttribute("profile", "yes");
		request.setAttribute("gallons",0);
//		request.setAttribute("fname", "");
//		request.setAttribute("add1", "");
//		request.setAttribute("add2", "");
//		request.setAttribute("city", "");
//		request.setAttribute("state", "");
//		request.setAttribute("zip", "");
		if(action.contentEquals("Quote Form"))
		{
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
		}
		else if(action.contentEquals("Profile Management"))
		{
			NewUserProfile newProfile = new NewUserProfile();
			String[] profileDetails = newProfile.fetchFromDB((String) this.getServletConfig().getServletContext().getAttribute("User"));//Session Tracking is not yet implemented. So the Username value is currently hardcoded
			String fname = profileDetails[0].replace(" ", ",");
			String add1 = profileDetails[1].replace(" ",",");
			String add2 = profileDetails[2].replace(" ", ",");
			String city = profileDetails[3].replace(" ",",");
			String state = profileDetails[4].replace(",","");
			int zip = Integer.parseInt(profileDetails[5]);
			if(fname.contentEquals("fail")) {
				request.setAttribute("error", "Unable to fetch from Database. Please try again");
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/ProfileMgt.jsp").forward(request,response);
				
			}
			else
			{
				request.setAttribute("fname", fname);
				request.setAttribute("add1", add1);
				request.setAttribute("add2", add2);
				request.setAttribute("city", city);
				request.setAttribute("state", state);
				request.setAttribute("zip", zip);
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/ProfileMgt.jsp").forward(request,response);
			}
			//response.setContentType("text/html");
			//request.getRequestDispatcher("/WEB-INF/views/ProfileMgt.jsp").forward(request,response);
		}
		else if(action.contentEquals("Log Out"))
		{
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			request.removeAttribute("User");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/Login1.jsp").forward(request,response);
		}
		//response.setContentType("text/html");
		//request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
	}
}