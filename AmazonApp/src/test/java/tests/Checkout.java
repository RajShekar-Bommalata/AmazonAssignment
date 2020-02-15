package tests;

import org.testng.annotations.Test;

import pages.CheckoutScreen;
import pages.PLP;
import utility.TestBase;


public class Checkout extends TestBase {

	@Test
	public void itemCheckout() throws Exception {
		CheckoutScreen checkout = new CheckoutScreen(driver);
		
		// Compare product names
		System.out.println(checkout.getItemNameOnCheckOut()+ " --**-- " + PLP.productNameInSearchPage);
		checkout.compareItemNames(checkout.getItemNameOnCheckOut(), PLP.productNameInSearchPage);
	}

}