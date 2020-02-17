package tests;

import org.testng.annotations.Test;

import pages.ShippingDetailsScreen;
import utility.TestBase;

public class ShippingDetails extends TestBase {

	@Test
	public void selectOrEnterShippingDetails() throws Exception {
		ShippingDetailsScreen shipping = new ShippingDetailsScreen(driver);
		/**
		 * This code selects default shipping address
		 */
		// Click on deliver to this address
		shipping.selectDefaultAddress();
		// Click on continue button
		shipping.clickOnContinueButton();
	}

}
