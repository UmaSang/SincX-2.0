package testCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

public class LoginDDT_one extends Baseclass {

	public WebDriverWait wait;

	@DataProvider(name = "excelData")
	public Object[][] readExcelData() {
		String excelFilePath = ".\\testData\\sincxapp_logindata.xlsx";
		Object[][] data = null;

		try (FileInputStream file = new FileInputStream(excelFilePath);
				XSSFWorkbook workbook = new XSSFWorkbook(file)) {

			XSSFSheet sheet = workbook.getSheet("Sheet1");

			// Find Number of Rows and Column
			int totalrows = sheet.getLastRowNum();
			int totalcol = sheet.getRow(0).getLastCellNum(); // Use first row to get total columns
			System.out.println("Number of rows: " + totalrows);
			System.out.println("Number of columns: " + totalcol);

			data = new Object[totalrows][3]; // Allocate array for data

			for (int i = 1; i <= totalrows; i++) {
				XSSFRow currentrow = sheet.getRow(i);
				if (currentrow == null) {
					// Handle empty row case
					System.out.println("Row " + i + " is empty.");
					continue; // Skip to the next iteration if the row is null
				}
				for (int j = 0; j < 3; j++) {
					XSSFCell cell = currentrow.getCell(j);
					if (cell != null) {
						data[i - 1][j] = cell.getStringCellValue();
					} else {
						data[i - 1][j] = ""; // Handle null cells gracefully
					}
					System.out.print(data[i - 1][j] + "\t");
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException occurred.");
			e.printStackTrace();
		}

		return data;
	}

	@Test(dataProvider = "excelData")
	public void verify_loginpageDDT(String Username, String Password, String Res) {

		try {
			Homepage lo = new Homepage(driver);
			logger.info(" LoginpageDDT is started");

			lo.set_domainname(p.getProperty("domainName"));
			lo.click_firstcontiunebutton();
			lo.set_username(Username);
			lo.click_secondcontiunebutton();
			lo.set_pwd(Password);
			lo.click_loginbutton();

		} catch (Exception e) {
			logger.error("...Login failed...");
			logger.debug("Debug logs");
			Assert.fail();
		}

	}

}

//			// boolean Sinlogo = lo.isConfirmationMsgDisplayed();
//
//			if (Res.equalsIgnoreCase("Valid")) {
//				System.out.println("Login is success");
//
//
//				lo.click_Sincxlogo();
//				lo.click_settingbutton();
//				lo.click_logout();
//
//			} else {
//				System.out.println("Login is failed");
//				Assert.assertTrue(false);
//			}
//
//		
//	}
//	
//
////
////			if (Res.equalsIgnoreCase("Invalid"))
////			{
////				if (Sinlogo == true)
////				{
////
////					lo.click_Sincxlogo();
////					lo.click_settingbutton();
////					lo.click_logout();
////
////					Assert.assertTrue(false);
////				} else {
////					Assert.assertTrue(true);
////				}
////			}
////
////		}
////
////		catch (Exception e) {
////			logger.error("...Login failed...");
////			logger.debug("Debug logs");
////			Assert.fail();
////		}
////
////	}
////
////}
//
////if(confmsg==true)
////{
////Assert.assertTrue(true);
////
//
////	if (Res.equalsIgnoreCase("Invalid"))
////			{
////
////		if(confmsg==true)
////		{
////		Assert.assertTrue(false);
////		logger.info("... Loginpage Assertion failed .....");
////
////	} else {
////		
////		Assert.assertTrue(true);
////	}
////		lo.click_profilebutton();
////		lo.click_adminmode();
////		lo.click_settingbutton();
////	    lo.click_logout();
////	    
////}
////
////}
//
////if(pwdalert==true)
////{
////    Assert.assertTrue(true);
////    
////	if (Res.equalsIgnoreCase("Invalid")) {
////		System.out.println("Password is wrong //Login is unsuccess");
////		
////	}
////	else {
////		System.out.println("Login is sucess");
////	}
////}
//
////try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
////        XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
////
////       XSSFSheet sheet = workbook.getSheetAt(0);
////       int rowCount = ((XSSFSheet) sheet).getPhysicalNumberOfRows();
////       int colCount = ((XSSFSheet) sheet).getRow(0).getPhysicalNumberOfCells();
////       data = new Object[rowCount - 1][colCount]; // Exclude header row
////        
////       for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header
////           Row row = ((XSSFSheet) sheet).getRow(i);
////           for (int j = 0; j < colCount; j++) {
////               Cell cell = row.getCell(j);
////               if (cell != null) {
////                   System.out.println(cell.toString());
////               } else {
////                   System.out.println("cell is null");
////               }
////
////               data[i - 1][j] = cell.toString(); // Store cell data as string
////           }
////       }
//
//// Data is valid--login success-test pass-logout
//// --login failed-test fail
//// Data id invalid-login success-test fail-logout
//// login failed --test pass
//
////@DataProvider(name = "excelData")
////public Object[][] readExcelData() {
////	String excelFilePath = ".\\testData\\sincxapp_logindata.xlsx";
////	Object[][] data = null;
////
////	try {
////		// Read from Excel file and //deal with Workbook
////		FileInputStream file = new FileInputStream(excelFilePath);
////		XSSFWorkbook workbook = new XSSFWorkbook(file);
////		XSSFSheet sheet = workbook.getSheet("Sheet1"); // Go to specific sheet to read from.
////
////		// Find Number of Rows and Column
////		int totalrows = sheet.getLastRowNum();
////		int totalcol = sheet.getRow(totalrows).getLastCellNum();
////		System.out.println("Number of rows:" + totalrows);
////		System.out.println("Number of Col:" + totalcol);
////		System.out.println("\t");
////		data = new Object[totalrows - 1][totalcol];
////		// Iterate over rows and columns using for..loop //2D array
////		for (int i = 1; i <= totalrows; i++) {
////			XSSFRow currentrow = sheet.getRow(i);
////			System.out.println("\t ");
////			for (int j = 0; j < totalcol; j++) {
////				XSSFCell cell = currentrow.getCell(j);
////				  data[i - 1][j] = (cell != null) ? cell.getStringCellValue() : "";
////				//data[i - 1][j] = cell.getStringCellValue().toString();
////				  System.out.print(data[i - 1][j] + "\t");
////				//System.out.print(cell.toString() + "\t");
////
////			}
////			System.out.println(" ");
////		}
////
////		// Close streams
////		file.close();
////		workbook.close();
////	} catch (IOException e) {
////		e.printStackTrace();
////	}
////	return data;
////}
