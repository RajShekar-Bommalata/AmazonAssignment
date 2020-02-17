package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.TestUtil;

public class SearchScreen extends TestUtil {
	// Using FindBy for locating elements
	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	WebElement search_input;

	public SearchScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// This method clicks on search input field
	public void clickOnSearchInput() {
		try {
			search_input.click();
			logMessageWithScreenShot("Clicked on search input", "4_SearchInput");
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_clickOnSearchInput");
			Assert.fail("Unable to click on search input");
		}
	}

	// This method is to input the product name in the search input and click enter
	public void searchForProduct(String productName) {
		try {
			search_input.sendKeys(productName, "\n");
			logMessage("Entered product name");
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_searchForProduct");
			Assert.fail("Unable to input value in search box");
		}
	}
}