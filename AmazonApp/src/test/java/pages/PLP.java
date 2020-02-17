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

public class PLP extends TestUtil {

	@FindBy(xpath = "//*[@resource-id=\"com.amazon.mShop.android.shopping:id/item_title\"]")
	private List<WebElement> productList;
	
	@FindBy(xpath = "//*[@resource-id='com.amazon.mShop.android.shopping:id/rs_corrections_mixed_quartz']")
	private WebElement searchResults;

	public PLP(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method fetches the desired product name and returns productNameInSearchPage
	 */
	public String getItemName() throws InterruptedException {
		waitForElement(driver, searchResults);
		String productNameInSearchPage = "";
		try {
			logMessage("List of Available products");
			for (WebElement list : productList) {
				logMessage(list.getText());
			}
			logMessageWithScreenShot("Search results displayed","5_ProductList");
			productNameInSearchPage = productList.get(2).getText();
			logMessage("Retrieved product name at second location");
		} catch (Exception e) {
			Assert.fail("Failed to get item name from search results page");
			logMessageWithScreenShot("Failed to get item name from search results page","Err_getItemName");
		}
		return productNameInSearchPage;
	}

	/**
	 * This method selects product from productListingPage
	 */
	public void selectAProduct() {
		try {
			waitForElement(driver, productList.get(2));
			//productNameInSearchPage = productList.get(2).getText();
			productList.get(2).click();
			logMessage(productList.get(2).getText() +"  Product is selected on search results page");
		}
		catch (Exception e) {
			Assert.fail("Failed to select product");
			logMessageWithScreenShot("Failed to select product","Err_selectAProduct");
		}
	}
}