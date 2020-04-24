package fuel_predictor_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewUserProfile {

	
	public boolean storeInDB(String username, String fullname,String address1, String address2, String city, String state, int zip)
	{
		//Method takes the values provided by the user from servlet and stores into the database based on the username provided.
		boolean flag = false;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = "insert into profile(username,full_name,address_1,address_2,city,state,zipcoe) values (?,?,?,?,?,?,?);";
			//ResultSet rs = st.executeQuery(query);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, username);
		    preparedStmt.setString (2, fullname);
		    preparedStmt.setString (3, address1);
		    preparedStmt.setString (4, address2);
		    preparedStmt.setString (5, city);
		    preparedStmt.setString (6, state);
		    preparedStmt.setLong (7, zip);
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
	
	public String[] fetchFromDB(String username)
	{
		//Profile Details are fetched from the database once configured and then sent back to the servlet.
		int flag=-1;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = "select * from profile where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String fullName = rs.getString("full_name");
			String add1 = rs.getString("address_1");
			String add2 = rs.getString("address_2");
			String city = rs.getString("city");
			String state = rs.getString("state");
			String zip = rs.getString("zipcoe");
			st.close();
			conn.close();
			String[] profile = {fullName,add1,add2, city,state, zip};
			return profile;

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
		
		String[] profile = {"fail","","", "", "", ""};
		return profile;
		
	}
	
	
}
