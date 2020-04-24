package fuel_predictor_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/quote.do")
public class QuoteServlet extends HttpServlet{

	private Quotemanagement newQuote = new Quotemanagement();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		System.out.println("Ateast coming to get!!!!!!!!!!!!!!!");
		//String add = newQuote.fetchAddressFromDB("TestUser");
		//request.setAttribute("del_adds", add);
		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		String action = request.getParameter("action");
		//System.out.println("ACtion ======================= "+action);
		request.setAttribute("gallons",0);
		request.setAttribute("profile", "yes");
		System.out.println("ACtion In Quote Page.............. "+action);
		if(action.contentEquals("Get Price"))
		{
			double gallons = Double.parseDouble(request.getParameter("numofgallons"));
			String date = request.getParameter("del_date");
			if(!date.contains("-"))
			{
				date = java.time.LocalDate.now().toString();  
			}
			else if(date.contains("-")) {
				 try {
					Date date1=new SimpleDateFormat("yyyy-dd-mm").parse(date);
					Date current= new SimpleDateFormat("yyyy-dd-mm").parse(java.time.LocalDate.now().toString());
					System.out.println("Entered Date ............. "+date1);
					System.out.println("current Date ............. "+current);
					if (date1.compareTo(current) > 0) {
						
			            System.out.println("Date1 is after Date2");
			        } else if (date1.compareTo(current) < 0) {
			        	request.setAttribute("message", "Entered date is before current date, Please try again");
			    		request.setAttribute("gallons",gallons);
						//response.setContentType("text/html");
						request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
			            System.out.println("Date1 is before Date2");
			        } else if (date1.compareTo(current) == 0) {
			            System.out.println("Date1 is equal to Date2");
			        } else {
			            System.out.println("How to get here?");
			        }

				 } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Date..................... "+date);
			
			//String deladdress = request.getParameter("deladd");
			String[] returnSet = newQuote.calculatePrice((String) this.getServletConfig().getServletContext().getAttribute("User"), gallons, date);
			System.out.println(Double.parseDouble(returnSet[0]));
			System.out.println(returnSet[1]);
			System.out.println(returnSet[2]);
			System.out.println(Double.parseDouble(returnSet[3]));
			System.out.println(Double.parseDouble(returnSet[4]));
			request.setAttribute("gallons", Double.parseDouble(returnSet[0]));
			request.setAttribute("del_adds", returnSet[1]);
			request.setAttribute("date", returnSet[2]);
			request.setAttribute("price", Double.parseDouble(returnSet[3]));
			request.setAttribute("total", Double.parseDouble(returnSet[4]));
			
			
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/QuoteForm2.jsp").forward(request,response);
		}
		else if(action.contentEquals("Submit"))
		{
			double gallons = Double.parseDouble(request.getParameter("numofgallons"));
			String date = request.getParameter("del_date");
			String deladdress = request.getParameter("deladd");
			double sug_price = Double.parseDouble(request.getParameter("sug_price"));
			double total_amt = Double.parseDouble(request.getParameter("total_amt"));
			//String deladdress = request.getParameter("deladd");
			//boolean quoteStatus = newQuote.storeQuoteInDB("user1",gallons,date,deladdress,sug_price,total_amt);
			boolean quoteStatus = newQuote.storeQuoteInDB((String) this.getServletConfig().getServletContext().getAttribute("User"), gallons, date, deladdress, sug_price, total_amt);
			if(quoteStatus == true)
			{
				System.out.println("Coming to Histtory..............................");
				QuoteHistoryServlet history = new QuoteHistoryServlet();
				List<List> BL = history.getHistory((String) this.getServletConfig().getServletContext().getAttribute("User"));
				List<String> ga = BL.get(0);
				List<String> add = BL.get(1);
				List<String> date1 = BL.get(2);
				List<String> sp = BL.get(3);
				List<String> ta = BL.get(4);
				List<List> fl = new ArrayList<List>();
				for (int counter = 0; counter < ga.size(); counter++) {
					List<String> temp = new ArrayList<String>();
					temp.add(ga.get(counter));
					temp.add(add.get(counter));
					temp.add(date1.get(counter));
					temp.add(sp.get(counter));
					temp.add(ta.get(counter));
					fl.add(temp);
			    }
				request.setAttribute("BL", fl);
				request.setAttribute("ga", ga);
				request.setAttribute("add", add);
				request.setAttribute("date", date1);
				request.setAttribute("sp", sp);
				request.setAttribute("ta", ta);
				response.setContentType("text/html");
				//request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
				//request.setAttribute("message", "Unable to process the Quote, Please try again");
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
				request.setAttribute("message", "Quote Completed Successfully");
				response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("message", "Unable to process the Quote, Please try again");
				//response.setContentType("text/html");
				request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
			}

		}
		else if(action.contentEquals("History"))
		{
			System.out.println("Coming to Histtory..............................");
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
			//request.setAttribute("message", "Unable to process the Quote, Please try again");
			response.setContentType("text/html");
			request.getRequestDispatcher("/WEB-INF/views/History.jsp").forward(request,response);
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
		
		
	}   
}
