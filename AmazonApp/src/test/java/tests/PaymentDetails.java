package tests;

import org.testng.annotations.Test;

import pages.PaymentScreen;
import utility.TestBase;


public class PaymentDetails extends TestBase {

	@Test
	public void selectPaymentDetails() throws Exception {
		PaymentScreen payment = new PaymentScreen(driver);
		
		// Click on continue button
		payment.clickNetBankingRadioButton();
		payment.selectBankName();
		payment.clickContinueButton();
	}

}