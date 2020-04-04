package fuel_predictor_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginPage {

	/* If isValidUser() returns 0 then the User is Invalid
	 * If it returns 1 the Password is incorrect for the user
	 * If it returns 2 Username and password are successfully validated
	 */
	@Test
	public void bothValid() {
		UserValidation user = new UserValidation();
		int flag = user.isValidUser("CorrectUser", "Correctpassword");
		assertEquals(2,flag);
	}
	
	
	/*public void isPasswordValid() {
		UserValidation user = new UserValidation();
		int flag = user.isValidUser("CorrectUser", "Wrongpassword");
		assertEquals(1,flag);
	}*/
	
	
	/*public void isUsernameValid() {
		UserValidation user = new UserValidation();
		int flag = user.isValidUser("WrongUser", "Correctpassword");
		assertEquals(0,flag);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public void bothValid() {
		UserValidation user = new UserValidation();
		int flag = user.isValidUser("CorrectUser", "Correctpassword");
		assertEquals(2,flag);
	}*/

}
