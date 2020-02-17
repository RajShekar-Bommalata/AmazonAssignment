package tests;

import org.testng.annotations.Test;

import pages.PLP;
import utility.TestBase;

public class SelectProduct extends TestBase {

	static String productNameInSearchPage;

	@Test
	public void selectAProduct() throws Exception {
		PLP plp = new PLP(driver);
		productNameInSearchPage = plp.getItemName();
		plp.selectAProduct();
	}

}