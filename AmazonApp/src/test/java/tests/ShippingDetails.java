package tests;

import org.testng.annotations.Test;

import pages.ShippingDetailsScreen;
import utility.TestBase;

public class ShippingDetails extends TestBase {

	@Test
	public void selectOrEnterShippingDetails() throws Exception {
		ShippingDetailsScreen shipping = new ShippingDetailsScreen(driver);
		
		/**
		 * This code adds new shipping details
		 */
		
		/*// Click on Add New Address Button
		shipping.addNewAddress();
		// Enter Full Name
		shipping.enterFullName(datafile.getFullName());
		// Enter Phone Number
		shipping.enterPhoneNumber(datafile.getPhoneNumber());
		// Enter Postal Code
		shipping.enterPostalCode(datafile.getPostalCode());
		// Enter City
		shipping.enterCity(datafile.getCity());
		// Enter State
		shipping.enterState(datafile.getState());
		// Enter AddressLine1
		shipping.enterAddressLine1(datafile.getAddressLine1());
		// Enter AddressLine2
		shipping.enterAddressLine2(datafile.getAddressLine2());
		// Enter Landmark
		shipping.enterLandmark(datafile.getLandmark());
		// Enter AddressLine1
		Thread.sleep(3000);
		shipping.hideKeyboard();
		// Select Address type
		shipping.clickOnAddressType();
		// Select Home Address
		shipping.selectAddressType();*/
		
		/**
		 * This code selects default shipping address
		 */
		// Click on deliver to this address
		shipping.selectDefaultAddress();
		// Click on continue button
		shipping.clickOnContinueButton();
	}

}