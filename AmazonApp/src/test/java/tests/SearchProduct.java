package tests;

import org.testng.annotations.Test;


import pages.SearchScreen;
import utility.TestBase;

public class SearchProduct extends TestBase {

	@Test
	public void searchForAProduct() throws Exception {

		SearchScreen search = new SearchScreen(driver);
		search.clickOnSearchInput();
		search.searchForProduct(datafile.getProductName());
	}

}