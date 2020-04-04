package fuel_predictor_project;

import java.io.IOException;
import java.io.PrintWriter;

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
		String add = newQuote.fetchAddressFromDB("TestUser");
		request.setAttribute("del_adds", add);
		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException 
	{
		double gallons = Double.parseDouble(request.getParameter("numofgallons"));
		String date = request.getParameter("del_date");
		String deladdress = request.getParameter("deladd");
		String[] returnSet = newQuote.calculatePrice("TestUser", gallons, date, deladdress);
		System.out.println(Double.parseDouble(returnSet[0]));
		System.out.println(returnSet[1]);
		System.out.println(returnSet[2]);
		System.out.println(Double.parseDouble(returnSet[3]));
		System.out.println(Double.parseDouble(returnSet[4]));
		String a= "dfvsvdthyjfkyky";
		request.setAttribute("gallons", Double.parseDouble(returnSet[0]));
		request.setAttribute("del_adds", returnSet[1]);
		request.setAttribute("date", returnSet[2]);
		request.setAttribute("price", Double.parseDouble(returnSet[3]));
		request.setAttribute("total", Double.parseDouble(returnSet[4]));
		
		response.setContentType("text/html");
		request.getRequestDispatcher("/WEB-INF/views/QuoteForm.jsp").forward(request,response);
		
	}   
}
