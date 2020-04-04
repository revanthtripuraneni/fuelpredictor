package fuel_predictor_project;

public class UserValidation {

	public int isValidUser(String username,String password)
	{
		String uname = "CorrectUser";	//Will be fetched from database
		String pass = "Correctpassword";	//Will be fetched from database
		int flag=0;
		if(username.equals(uname))
		{
			flag=1;
			if(password.equals(pass))
			{
				flag = 2;
			}

			//Also check if password is not valid and username does'nt exist
		}
		
		return flag;
	}
}
