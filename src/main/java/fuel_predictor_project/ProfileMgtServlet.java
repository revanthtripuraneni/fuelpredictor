package fuel_predictor_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		String[] profileDetails = newProfile.fetchFromDB((String) this.getServletConfig().getServletContext().getAttribute("User"));//Session Tracking is not yet implemented. So the Username value is currently hardcoded
		String fname = profileDetails[0];
		String add1 = profileDetails[1];
		String add2 = profileDetails[2];
		String city = profileDetails[3];
		String state = profileDetails[4];
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
		
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		//String jspname = request.getParameter("jspname");
		String action = "";
		action = request.getParameter("action");
		request.setAttribute("gallons",0);
		request.setAttribute("fname", " ");
		request.setAttribute("add1", " ");
		request.setAttribute("add2", " ");
		request.setAttribute("city", " ");
		request.setAttribute("state", " ");
		request.setAttribute("zip", " ");
		String zip = (String)request.getParameter("zip");
		if(action.contentEquals("Submit"))
		{
			String name = request.getParameter("fullname");
			String add1 = request.getParameter("address1");
			String add2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			zip = (String)request.getParameter("zip");
			System.out.println("Zip Value .........."+zip);
			if(zip.toString().length()<5 || zip.toString().length()>9)
			{
				request.setAttribute("error", "Zipcode should be of 5-9 characters long");
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/ProfileMgtNewUser.jsp").forward(request,response);
			}
			else
			{
				//System.out.println("=========================================================Coming Here"+zip);
				boolean isStored = newProfile.storeInDB((String) this.getServletConfig().getServletContext().getAttribute("User"), name, add1, add2, city, state, Integer.parseInt(zip));
					
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
		else if(action.contains("History"))
		{
			if(zip.length()>4)
			{
				QuoteHistoryServlet history = new QuoteHistoryServlet();
				List<List> BL = history.getHistory((String) this.getServletConfig().getServletContext().getAttribute("User"));
				List<String> ga = BL.get(0);
				List<String> add = BL.get(1);
				List<String> date = BL.get(2);
				List<String> sp = BL.get(3);
				List<String> ta = BL.get(4);
				List<List> fl = new ArrayList<List>();
				for (int counter = 0; counter < ga.size(); counter++) {
					List<String> temp = new ArrayList<String>();
					temp.add(ga.get(counter));
					temp.add(add.get(counter));
					temp.add(date.get(counter));
					temp.add(sp.get(counter));
					temp.add(ta.get(counter));
					fl.add(temp);
			    }
				request.setAttribute("BL", fl);
				request.setAttribute("ga", ga);
				request.setAttribute("add", add);
				request.setAttribute("date", date);
				request.setAttribute("sp", sp);
				request.setAttribute("ta", ta);
				response.setContentType("text/html");
				//request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("error", "Please complete your profile first");
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/ProfileMgt.jsp").forward(request,response);
			}
			
		}
		else if(action.contentEquals("Quote Form"))
		{
			if(zip.length()>4)
			{
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("error", "Please complete your profile first");
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/ProfileMgt.jsp").forward(request,response);
			}

		}
		else if(action.contentEquals("Log Out"))
		{
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			request.removeAttribute("User");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/Login1.jsp").forward(request,response);
		}
		
		
		
	}  

}
