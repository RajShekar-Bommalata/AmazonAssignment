package pages;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.TestUtil;

public class HomeScreen extends TestUtil {

	@FindBy(id = "com.amazon.mShop.android.shopping:id/sso_continue")
	WebElement continue_button;
	@FindBy(xpath = "//android.widget.RadioButton[@text='English - EN']")
	WebElement english_radio;
	@FindBy(xpath = "//android.widget.Button[@text='Save Changes']")
	WebElement saveChanges_button;

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method clicks on continue button on sign in page. App uses already
	 * signed in account
	 */
	public void clickOnContinueButton() {
		try {
			//Rotate landscape mode
			rotate(ScreenOrientation.LANDSCAPE);
			logMessage("Waiting for signin page to load");
			waitForElement(driver, continue_button);
			logMessageWithScreenShot("Signin page is loaded", "1_SigninPage");
			// Click on continue button
			continue_button.click();
			logMessage("Clicked on Continue button");
			//Rotate portrait mode
			rotate(ScreenOrientation.PORTRAIT);
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_clickOnContinueButton");
			Assert.fail("Failed to Click on Continue button");
		}
	}

	/**
	 * This method selects English Radio button
	 */
	public void selectLanguageButton() {
		try {
			// Wait for popup with language selection to appear on the screen
			logMessage("Waiting for language selection popup to appear");
			waitForElement(driver, english_radio);
			// Select English Language
			english_radio.click();
			logMessageWithScreenShot("Clicked on English radio button", "2_SelectLanguage");
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_selectLanguageButton");
			Assert.fail("Unable to select language button");
		}
	}

	/**
	 * This method clicks on save changes button
	 */
	public void clickOnSaveChangesButton() {
		try {
			// Click on save changes button
			saveChanges_button.click();
			logMessageWithScreenShot("Clicked on save changes button", "3_SaveChanges");
		} catch (Exception e) {
			logErrorMessageWithScreenShot(e.toString(), "Err_clickOnSaveChangesButton");
			Assert.fail("Unable to click on save changes button");
		}

	}
}