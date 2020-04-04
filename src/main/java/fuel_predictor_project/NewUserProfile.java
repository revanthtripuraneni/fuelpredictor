package fuel_predictor_project;

public class NewUserProfile {

	
	public boolean storeInDB(String username, String fullname,String address1, String address2, String city, String state, int zip)
	{
		//Method takes the values provided by the user from servlet and stores into the database based on the username provided.
		boolean flag = true;
		if(flag)
		{
			System.out.println("Stored in DB");
			return true;
		}
		else
			return false;
		
	}
	
	public String[] fetchFromDB(String username)
	{
		//Profile Details are fetched from the database once configured and then sent back to the servlet.
		String[] profile = {"Test User","Cambridge St","Scot Apts", "Houston", "TX", "12345"};
		return profile;
		
	}
	
	
}
