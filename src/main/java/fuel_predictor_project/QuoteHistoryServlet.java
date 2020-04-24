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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class QuoteHistoryServlet {
	
	public List<List> getHistory(String username)
	{
		List<String> gallon = new ArrayList<String>();
		List<String> da = new ArrayList<String>();
		List<String> dd = new ArrayList<String>();
		List<String> sp = new ArrayList<String>();
		List<String> ta = new ArrayList<String>();
		List<List> BigList = new ArrayList<List>();
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuel_predictor","root","Mypassword@19");
			Statement st = conn.createStatement();
			String query = "select * from quote where username='"+username+"'";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String gal = Double.toString(rs.getDouble("gallons"));
				gallon.add(gal);
				String del_add = rs.getString("del_address");
				da.add(del_add);
				String del_dat = rs.getString("del_date");
				dd.add(del_dat);
				String sug_pr = Double.toString(rs.getDouble("sugg_price"));
				sp.add(sug_pr);
				String tot_amt = Double.toString(rs.getDouble("total_amt"));
				ta.add(tot_amt);
			}
			BigList.add(gallon);
			BigList.add(da);
			BigList.add(dd);
			BigList.add(sp);
			BigList.add(ta);
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
		return BigList;
	}

}