package fuel_predictor_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriceModule {

	@Test
	public void test() {
		Quotemanagement quote = new Quotemanagement();
		String[] price = quote.calculatePrice("pranay", 100,"2020-04-25");
		assertEquals("1.755",price[2]);
		//assertEquals("175.5",price[3]);
	}

}
