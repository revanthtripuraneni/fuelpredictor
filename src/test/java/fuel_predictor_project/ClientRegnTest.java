package fuel_predictor_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientRegnTest {

	//If passwordCheck() returns 1 then password and confirm password match
	//If passwordCheck() returns 0 then password and confirm password does'nt match
	//If passwordCheck() returns -1 then Password Length is less than 8
	//If passwordCheck() returns -2 then Password Contains symbols other than alphabets or digits
	@Test
	public void passwordCheck() {
		NewUserValidation user = new NewUserValidation();
		int flag = user.passwordCheck("qwerty1233", "abchdhdj2");
		assertEquals(0,flag);
	}
	

}
