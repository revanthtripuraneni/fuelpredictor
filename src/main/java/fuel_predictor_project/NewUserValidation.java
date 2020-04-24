package fuel_predictor_project;

import java.sql.*;

public class NewUserValidation {
	
	public int newUserValidation1(String username)
	{
		Connection conn = null;
		int flag = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = "select * from users where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				System.out.println("User Exists=======================================================");
				return 0;
			}
			else {
				System.out.println("Not Exists*********************************************************");
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

		return flag;
	}
	
	public int profileValidation(String username)
	{
		Connection conn = null;
		int flag = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = "select * from profile where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				System.out.println("Profile Exists=======================================================");
				return 0;
			}
			else {
				System.out.println("Profile Does'nt Exists*********************************************************");
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

		return flag;
	}
	
	public int passwordCheck(String password,String ConfirmPassword)
	{
		int flag = 0;
		if(password.contentEquals(ConfirmPassword))
		{
			flag = 1;
			  if (password.length() < 8)
			  {   
		            return -1;  //If Password Length is less than 8
		      } 
			  else 
			  {      
		            char c;  
		            int count = 0;   
		            for (int i = 0; i < password.length() - 1; i++) {  
		                c = password.charAt(i);  
		                if (!Character.isLetterOrDigit(c)) {          
		                    return -2;  //If Password Contains symbols other than alphabets or digits
		                }     
		                 
		            }  
		        }  
		}
		return flag;
		
	}
	
	public int createNewUser(String name,String password)
	{
		Connection conn = null;
		int flag = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = " insert into users(username,password) values(?,?);";
			//ResultSet rs = st.executeQuery(query);
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, name);
		    preparedStmt.setString (2, password);
		    preparedStmt.execute();
		    flag = 1;

		}
		catch(Exception e) {
			System.out.println("Database Error");
			e.printStackTrace();
			flag = 0;
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
