package fuel_predictor_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Quotemanagement {
	
	public String[] calculatePrice(String username, double gallons,String date)
	{
		//Method takes the values provided by the user from servlet and stores into the database based on the username provided.
		double suggestedPrice = 0.0;	//Calculated and received from pricing module(not yet implemented)
		boolean flag = true;
		String address = "";
		double totalamt = 0.0;
		double currentPrice = 1.50;
		double companyProfitFactor = 0.1;
		double rateFluctuation = 0.0;
		double gallonsReqFactor = 0.0;
		double locationFactor = 0.0;
		double rateHistoryFactor = 0.0;
		String month = "";
		System.out.println("Date............ "+date);
		if(date.contains("-"))
		{
			month  = Character.toString(date.charAt(5))+Character.toString(date.charAt(6));
		}
		else {
			month = "01";
		}
		
		String state = "";
		boolean history = false;
		double margin = 0.0;
		
		if(month.contentEquals("06") || month.contentEquals("07") || month.contentEquals("08"))
		{
			rateFluctuation = 0.04;
		}
		else
		{
			rateFluctuation = 0.03;
		}
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = "select * from profile where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String add1 = rs.getString("address_1");
			String add2 = rs.getString("address_2");
			String city = rs.getString("city");
			state = rs.getString("state");
			String zip = rs.getString("zipcoe");
			address = add1.replace(" ", ",")+","+add2.replace(" ", "-")+","+city+","+state+","+zip;
			st.close();
			conn.close();

		}
		catch(Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		
		//Initializing Location Factor
		if(state.toUpperCase().contentEquals("TX"))
		{
			locationFactor = 0.02;
		}
		else
		{
			locationFactor = 0.04;
		}
		
		//Fetching History Details
		Connection conn1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn1.createStatement();
			String query = "select * from quote where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next())
			{
				history = true;
			}
			else
				history = false;
			st.close();
			conn1.close();

		}
		catch(Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(conn1!=null)
		        	 conn1.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		
		if(history == true)
		{
			rateHistoryFactor = 0.01;
		}
		else
		{
			rateHistoryFactor = 0.0;
		}
		
		if(gallons > 1000)
		{
			gallonsReqFactor = 0.02;
		}
		else
		{
			gallonsReqFactor = 0.03;
		}
		
		margin = currentPrice*(locationFactor - rateHistoryFactor + gallonsReqFactor + companyProfitFactor + rateFluctuation);
		suggestedPrice = currentPrice + margin;
		totalamt = gallons*suggestedPrice;
		String[] returnSet = {Double.toString(gallons),address,date,Double.toString(suggestedPrice),Double.toString(totalamt)};
		//Method to store delivery address, date, gallons, suggested price, total amount into DB History Table
		//System.out.println("Coming to Quotemat class "+suggestedPrice);
		System.out.println("Location Factor  "+locationFactor);
		System.out.println("History Factor  "+rateHistoryFactor);
		System.out.println("Galloms Factor  "+gallonsReqFactor);
		System.out.println("Rate Fluctuation Factor  "+rateFluctuation);
		System.out.println("Company Profit Factor  "+companyProfitFactor);
		System.out.println("State  "+state);
		System.out.println("Month  "+month);
		return returnSet; 
		
	}
	
	public boolean storeQuoteInDB(String username,double gallons,String date,String address,double suggPrice,double totalAmt)
	{
		boolean flag = false;
		//Address is fetched from the database once configured and then sent back to the servlet.
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = "insert into quote(username,gallons,del_address,del_date,sugg_price,total_amt) values (?,?,?,?,?,?);";
			//ResultSet rs = st.executeQuery(query);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, username);
		    preparedStmt.setDouble(2, gallons);
		    preparedStmt.setString (4, date);
		    preparedStmt.setString (3, address);
		    preparedStmt.setDouble (5, suggPrice);
		    preparedStmt.setDouble (6, totalAmt);
		    preparedStmt.execute();
		    flag = true;

		}
		catch(Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
			flag = false;
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		
		return flag;
		
	}

}
