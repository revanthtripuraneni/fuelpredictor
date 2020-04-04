package fuel_predictor_project;

public class NewUserValidation {
	
	public boolean newUserValidation1(String username)
	{
		String[] uname = {"TestUser","TestUser1","TestUser2","UserExists"};
		int flag = 0;
		for(int i=0;i<uname.length;i++)
		{
			if(username.equals(uname[i]))
			{
				flag = 1;
				break;
			}
			
		}
		if(flag == 1)
		{
			return false;
			
		}
		else
			return true;
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

}
