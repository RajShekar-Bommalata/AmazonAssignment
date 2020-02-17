package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.TestUtil;

public class CheckoutScreen extends TestUtil {

	@FindBy(xpath = "//android.view.View[@resource-id='spc-orders']/android.view.View[8]/android.view.View[4]")
	private WebElement actualItemName;

	public CheckoutScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Get selected item name from CheckOut page
	 */

	public String getItemNameOnCheckOut() {
		for (int scrollCount = 0; scrollCount < 5; scrollCount++) {
			scrollDown();
		}
		String productNameInCheckout = "";
		waitForElement(driver, actualItemName);
		try {
			productNameInCheckout = actualItemName.getText();
			logMessageWithScreenShot("Product name captured in checkout..", "checkout");
		} catch (Exception e) {
			Assert.fail("Failed to get item name from check out page");
			logMessageWithScreenShot("Failed to get item name from check out page..", "Err_getItemNameOnCheckOut");
		}
		return productNameInCheckout;
	}

	/**
	 * Compare device names between search results and checkout
	 */
	public void compareItemNames(String actualProduct, String expectedProduct) {
		try {
			Assert.assertEquals(actualProduct, expectedProduct, "Products Verified");
		} catch (Exception e) {
			Assert.fail("Failed to compare both values");
		}
	}
}
