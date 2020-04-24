package fuel_predictor_project;

import java.sql.*;

public class UserValidation {

	public int isValidUser(String username,String password) throws SQLException, ClassNotFoundException
	{
		
		int flag=-1;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			System.out.println("Coming Here==================");
			String query = "select * from users where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				System.out.println("User Exists=======================================================");	
			}
			else {
				System.out.println("Not Exists*********************************************************");
				return 0;
			}
			//rs.next();
			String user_pwd = rs.getString("password");
			st.close();
			conn.close();
			if(user_pwd.contentEquals(password)) {
				System.out.println("Password Validated");
				flag=2;
			}else {
				System.out.println("Incorrect Password");
				return 1;
			}

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
		
		Connection conn2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn2.createStatement();
			System.out.println("Coming Here==================");
			String query = "select * from profile where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				System.out.println("Profile Exists=======================================================");
			}
			else {
				System.out.println("Profile Does'nt Exists*********************************************************");
				return -2;
			}

		}
		catch(Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(conn2!=null)
		        	 conn2.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
			
		
		return flag;
	}
}
