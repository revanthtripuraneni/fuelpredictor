package fuel_predictor_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class PricingModule {

	//If passwordCheck() returns 1 then password and confirm password match
	//If passwordCheck() returns 0 then password and confirm password does'nt match
	//If passwordCheck() returns -1 then Password Length is less than 8
	//If passwordCheck() returns -2 then Password Contains symbols other than alphabets or digits
	@Test
	public void test() {
		Quotemanagement quote = new Quotemanagement();
		String[] price = quote.calculatePrice("pranay", 100,"2020-04-25");
		assertEquals("1.755",price[2]);
		//assertEquals("175.5",price[3]);
	}
	

}
