package tests;

import org.testng.annotations.Test;

import pages.HomeScreen;
import utility.TestBase;

public class Home extends TestBase {

	@Test
	public void loginAndSelectLanguage() throws Exception {

		HomeScreen homepage = new HomeScreen(driver);
		homepage.clickOnContinueButton();
		homepage.selectLanguageButton();
		homepage.clickOnSaveChangesButton();
	}

}