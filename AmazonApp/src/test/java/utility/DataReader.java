package utility;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	public static Sheet fetchDataSheet() throws InvalidFormatException, IOException {
		File testDataFile = new File("../AmazonApp/resources/TestData.xlsx");
		FileInputStream inputStream = new FileInputStream(testDataFile);
		Workbook book = new XSSFWorkbook(testDataFile);
		Sheet sheet = book.getSheetAt(0);
		return sheet;
	}

	// This method gets the product name from data file
	public String getProductName() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(0).getStringCellValue();
	}

	// This method gets the FullName from data file
	public String getFullName() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(1).getStringCellValue();
	}

	// This method gets the PhoneNumber from data file
	public int getPhoneNumber() throws InvalidFormatException, IOException {
		return (int) fetchDataSheet().getRow(1).getCell(2).getNumericCellValue();
	}

	// This method gets the PostalCode from data file
	public int getPostalCode() throws InvalidFormatException, IOException {
		return (int) fetchDataSheet().getRow(1).getCell(3).getNumericCellValue();
	}

	// This method gets the City from data file
	public String getCity() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(4).getStringCellValue();
	}

	// This method gets the State from data file
	public String getState() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(5).getStringCellValue();
	}

	// This method gets the AddressLine1 from data file
	public String getAddressLine1() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(6).getStringCellValue();
	}

	// This method gets the AddressLine2 from data file
	public String getAddressLine2() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(7).getStringCellValue();
	}

	// This method gets the Landmark from data file
	public String getLandmark() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(8).getStringCellValue();
	}
	public String getBankName() throws InvalidFormatException, IOException {
		return fetchDataSheet().getRow(1).getCell(9).getStringCellValue();
	}
}
