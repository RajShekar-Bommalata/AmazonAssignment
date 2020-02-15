package pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.TestUtil;

public class ShippingDetailsScreen extends TestUtil {

	@FindBy(xpath = "//android.view.View[@text='Add a New Address']")
	WebElement addNewAddressButton;
	@FindBy(id = "enterAddressFullName")
	WebElement fullName;
	@FindBy(id = "enterAddressPhoneNumber")
	WebElement phoneNumber;
	@FindBy(id = "enterAddressPostalCode")
	WebElement postalCode;
	@FindBy(id = "enterAddressCity")
	WebElement city;
	@FindBy(id = "enterAddressStateOrRegion")
	WebElement state;
	@FindBy(id = "enterAddressAddressLine1")
	WebElement address1;
	@FindBy(id = "enterAddressAddressLine2")
	WebElement address2;
	@FindBy(id = "enterAddressLandmark")
	WebElement landmark;
	@FindBy(id = "AddressType")
	WebElement addressType;
	@FindBy(id = "AddressType_1")
	WebElement homeAddress;
	@FindBy(xpath = "//android.widget.Button")
	WebElement deliverToThisAddressButton;
	@FindBy(xpath = "//android.widget.Button['Continue']")
	WebElement continueButton;
	@FindBy(xpath = "//*[@text='Continue']")
	private WebElement buttonContinue;

	public ShippingDetailsScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectDefaultAddress() {
		try {
			logMessage("Waiting for Deliver to this address button");
			waitForElement(driver, deliverToThisAddressButton);
			logMessageWithScreenShot("Deliver to this address button visible", "8_ShippingAddress");
			deliverToThisAddressButton.click();
			logMessage("Clicked on deliver to this address button...");
		} catch (Exception e) {
			Assert.fail("Failed to click on deliver to this address button");
			logMessageWithScreenShot("Failed to click on Deliver to this address button", "Err_selectDefaultAddress");
		}
	}

	// This method clicks on add new address button
	public void addNewAddress() throws InterruptedException {
		waitForElement(driver, addNewAddressButton);
		// scroll the screen for addNewAddressButton
		for (int scrollCount = 0; scrollCount < 3; scrollCount++) {
			scrollDown();
		}
		logMessage("Scroll Complete...");
		addNewAddressButton.click();
	}

	public void enterFullName(String name) {
		fullName.sendKeys(name, "\t");
	}

	public void enterPhoneNumber(int phone) {
		phoneNumber.sendKeys(Integer.toString(phone), "\t");
	}

	public void enterPostalCode(int zip) {
		postalCode.sendKeys(Integer.toString(zip), "\t");
	}

	public void enterCity(String cityName) {
		city.clear();
		city.sendKeys(cityName, "\t");
	}

	public void enterState(String stateName) {
		state.clear();
		state.sendKeys(stateName, "\t");
	}

	public void enterAddressLine1(String line1) {
		address1.sendKeys(line1, "\t");
	}

	public void enterAddressLine2(String line2) {
		address2.sendKeys(line2, "\t");
	}

	public void enterLandmark(String landmarkName) {
		landmark.sendKeys(landmarkName, "\t");
	}

	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	public void clickOnAddressType() {
		addressType.click();
		log.info("Clicked on address type");
	}

	public void selectAddressType() {
		homeAddress.click();
	}

	public void clickOnDeliverToThisAddress() {
		deliverToThisAddressButton.click();
	}

	public void clickOnContinueButton() {
		try {
			logMessage("Waiting for continue button to be displayed");
			waitForElement(driver, buttonContinue);
			logMessageWithScreenShot("continue button is Visible", "ContinueButton");
			buttonContinue.click();
			logMessage("Clicked on Continue Button");
		} catch (Exception e) {
			Assert.fail("Failed to click on continue button ");
			logMessageWithScreenShot("Failed to continue button ", "Err_clickOnContinueButton");
		}
	}
}