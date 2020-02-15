package tests;

import org.testng.annotations.Test;

import pages.PLP;
import utility.TestBase;

public class SelectProduct extends TestBase {

	@Test
	public void selectAProduct() throws Exception {
		PLP plp = new PLP(driver);
		plp.getItemName();
		plp.selectAProduct();
	}

}