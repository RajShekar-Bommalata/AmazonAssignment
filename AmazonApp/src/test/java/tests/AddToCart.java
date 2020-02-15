package tests;

import org.testng.annotations.Test;

import pages.PDP;
import utility.TestBase;

public class AddToCart extends TestBase {

	@Test
	public void AddItemToCart() throws Exception {
		PDP pdp = new PDP(driver);
		pdp.addProductToCart();
		pdp.navigateToCartScreen();
		pdp.proceedToCheckout();
	}

}