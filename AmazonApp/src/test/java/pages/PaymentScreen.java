package pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utility.TestUtil;

public class PaymentScreen extends TestUtil {

	@FindBy(xpath = "//*[@text='Net Banking']/following::android.widget.Button[@text='Continue']")
	private WebElement buttonContinue;

	@FindBy(xpath = "//*[@text='Net Banking']/preceding::android.widget.RadioButton[2]")
	private WebElement radioButtonNetBanking;

	@FindBy(xpath = "//*[@text='Choose an Option']")
	private WebElement dropDownBankName;

	@FindBy(xpath = "//android.widget.ListView/android.view.View")
	private List<WebElement> bankOptions;
	
	public PaymentScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Select Net Banking payment option
	 */
	public void clickNetBankingRadioButton() {
		try {
			logMessageWithScreenShot("Scrolling to view net banking option", "Net Banking");
			for (int scrollCount = 0; scrollCount < 6; scrollCount++) {
				scrollDown();
			}
			
			waitForElement(driver,radioButtonNetBanking);
			logMessage("Scroll Complete and net banking option is visible");
			radioButtonNetBanking.click();
			logMessageWithScreenShot("Clicked on net banking radio button","Net Banking radio");
			
		} catch (Exception e) {
			Assert.fail("Failed to click NetBanking button");
			logMessageWithScreenShot("Failed to click NetBanking button","Err_clickNetBankingRadioButton");
			
		}
	}
	
	public void selectBankName() {
		try {
			dropDownBankName.click();
			logMessageWithScreenShot("Clicked on bank dropdown", "Bank List");
			for (WebElement bank : bankOptions) {
				if (bank.getText().equalsIgnoreCase(datafile.getBankName())) {
					bank.click();
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail("Selecting Bank Name Failed");
			logMessageWithScreenShot("Failed to select bank name","Err_selectBankName");
		}
	}

	/**
	 * Click Continue button
	 */
	public void clickContinueButton() {
		try {
			waitForElement(driver,buttonContinue);
			buttonContinue.click();
			Reporter.log("Continue button is clicked");
		} catch (Exception e) {
			Assert.fail("Failed to click continue button");
		}
	}
}
