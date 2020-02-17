package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.TestUtil;

public class PDP extends TestUtil {

	@FindBy(xpath = "//android.view.View[@resource-id='title_feature_div']")
	WebElement productName_pdp;
	@FindBy(xpath = "//android.view.View[@resource-id='size_name-button']/android.widget.Button")
	WebElement productSize_pdp;
	@FindBy(xpath = "//android.view.View[@resource-id='atfRedesign_priceblock_priceToPay']//android.widget.EditText")
	WebElement productPrice_pdp;
	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;
	@FindBy(id = "a-autoid-0-announce")
	WebElement cartButton;
	@FindBy(xpath = "//android.widget.Button[@text='Proceed to Buy']")
	WebElement proceedToCheckoutButton;

	// Click on the product

	public PDP(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method clicks on Add to Cart button
	 */
	public void addProductToCart() throws InterruptedException {
		try {
			waitForElement(driver, addToCartButton);
			logMessage("Scrolling down  Add to Cart Button...");
			for (int scrollCount = 0; scrollCount < 4; scrollCount++) {
				scrollDown();
			}
			logMessageWithScreenShot("Scroll Complete...", "6_Add to cart");
			Thread.sleep(5000);
			addToCartButton.click();
			logMessage("Clicked on Add to Cart Button...");
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_addProductToCart");
			Assert.fail("Failed to click on Add to Cart Button");
		}
	}

	/**
	 * This method clicks on cart button
	 */
	public void navigateToCartScreen() {
		try {
			waitForElement(driver, cartButton);
			takeScreenshot("7_Cart");
			logMessageWithScreenShot("Cart popup displayed", "7_Cart Screen popup");
			cartButton.click();
			logMessage("Clicked on Cart Button...");
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_navigateToCartScreen");
			Assert.fail("Failed to click on Cart Button");
		}
	}

	/**
	 * This method clicks on proceedToCheckout button
	 */
	public void proceedToCheckout() {
		try {
			logMessage("Waiting for Proceed to checkout button");
			waitForElement(driver, proceedToCheckoutButton);
			logMessageWithScreenShot("Proceed to checkout button visible", "8_Proceed To Checkout");
			proceedToCheckoutButton.click();
			logMessage("Clicked on Proceed to checkout Button...");
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_selectBankName");
			Assert.fail("Failed to click on Proceed to checkout button");
		}
	}
}