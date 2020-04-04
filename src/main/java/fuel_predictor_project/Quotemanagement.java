package fuel_predictor_project;

public class Quotemanagement {
	
	public String[] calculatePrice(String username, double gallons,String date,String del_address)
	{
		//Method takes the values provided by the user from servlet and stores into the database based on the username provided.
		double suggestedPrice = 10.0;	//Calculated and received from pricing module(not yet implemented)
		boolean flag = true;
		double totalamt = gallons*suggestedPrice;
		String[] returnSet = {Double.toString(gallons),"CambridgeApts_Houston_TX_12345",date,Double.toString(suggestedPrice),Double.toString(totalamt)};
		//Method to store delivery address, date, gallons, suggested price, total amount into DB History Table
		System.out.println("Coming to Quotemat class "+suggestedPrice);
		return returnSet; 
		
	}
	
	public String fetchAddressFromDB(String username)
	{
		//Address is fetched from the database once configured and then sent back to the servlet.
		String address = "Cambridge St, Scot Apts, Houston, TX, 12345";
		System.out.println(address);
		return address;
		
	}

}
