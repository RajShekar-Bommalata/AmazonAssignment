package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.TestUtil;

public class CheckoutScreen extends TestUtil {


	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/item_title\"]")
	private WebElement actualItemName;

	
	public CheckoutScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * Get selected item name from CheckOut page
	 */

	public String getItemNameOnCheckOut() {
		scrollDown();
		scrollDown();
		String productNameInCheckout = "";
		waitForElement(driver,actualItemName);
		try {
			productNameInCheckout = actualItemName.getText();
			Reporter.log("Got item name from check out page");
		} catch (Exception e) {
			Assert.fail("Failed to get item name from check out page");
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
