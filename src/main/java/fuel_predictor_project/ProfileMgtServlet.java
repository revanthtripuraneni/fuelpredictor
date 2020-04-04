package fuel_predictor_project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/profilemgt.do")
public class ProfileMgtServlet extends HttpServlet{
	
	private NewUserProfile newProfile = new NewUserProfile();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String[] profileDetails = newProfile.fetchFromDB("TestUser");//Session Tracking is not yet implemented. So the Username value is currently hardcoded
		String fname = profileDetails[0];
		String add1 = profileDetails[1];
		String add2 = profileDetails[2];
		String city = profileDetails[3];
		String state = profileDetails[4];
		int zip = Integer.parseInt(profileDetails[5]);
		request.setAttribute("fname", fname);
		request.setAttribute("add1", add1);
		request.setAttribute("add2", add2);
		request.setAttribute("city", city);
		request.setAttribute("state", state);
		request.setAttribute("zip", zip);
		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/views/ProfileMgt.jsp").forward(request,response);
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String name = request.getParameter("fullname");
		String add1 = request.getParameter("address1");
		String add2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		System.out.println("=========================================================Coming Here"+zip);
		boolean isStored = newProfile.storeInDB("TestUser", name, add1, add2, city, state, Integer.parseInt(zip));
		
		if(isStored)
		{
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("error", "Unable to store in Database, Please try again");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/ProfileMgt.jsp").forward(request,response);
		}
	}  

}
