package tests;

import org.testng.annotations.Test;

import pages.CheckoutScreen;
import utility.TestBase;


public class Checkout extends TestBase {

	@Test
	public void itemCheckout() throws Exception {
		CheckoutScreen checkout = new CheckoutScreen(driver);
		
		/**
		 * Compare product names at checkout
		 */
		checkout.compareItemNames(checkout.getItemNameOnCheckOut(), SelectProduct.productNameInSearchPage);
	}

}