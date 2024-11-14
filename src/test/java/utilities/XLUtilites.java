package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilites {
   
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public  static Object[][] getExceldata(int sheetind) throws IOException, FileNotFoundException {
		String path = ".\\testData\\sincxlogin_data.xlsx";
		File src = new File(path);
		FileInputStream excel = new FileInputStream(src);

		try (XSSFWorkbook workb = new XSSFWorkbook(excel)) {
			// load the sheet from above excel workbook
			XSSFSheet sheet = workb.getSheetAt(sheetind);

			// how many total rows in my excel sheet
			int rowCount = sheet.getLastRowNum();

			int cellCount = sheet.getRow(0).getLastCellNum();

			Object[][] testdata = new Object[rowCount][cellCount];

			for (int i = 1; i < rowCount + 1; i++) {
				Row r = sheet.getRow(i);

				for (int j = 0; j < cellCount; j++) {
					testdata[i-1][j]=r.getCell(j).getStringCellValue().toString();
					System.out.println(testdata[i-1][j]=r.getCell(j).getStringCellValue());
					
				}
			}
				
			
			return testdata;
		}
	}
		
}

//	public String[][] getData() throws IOException {
//		
//		String path = ".\\testData\\sincxapp_logindata.xlsx"; // taking xl file from testdata
//		File src = new File(path);
//		FileInputStream excel = new FileInputStream(src);
//
////	 ExcelUtility xlutil=new ExcelUtility(path);   //Creating an object for XLUtitlity
//
//		int totalrows = excel.getRowCount("Sheet1");
//		int totalcols = excel.getCellCount("Sheet1", 1);
//
//		String logindata[][] = new String[totalrows][totalcols]; // Created for two dimensional array which can store
//
//		for (int i = 1; i <= totalrows; i++)// 1 //read the data from xl storing in two dimensional
//		{
//			for (int j = 0; j < totalcols; j++) // 0 i is rows j is col
//			{
//				logindata[i - 1][j] = excel.getCellData("Sheet1", i, j);
//			}
//		}
//		return logindata;
//		// returning two dimension array
//	}


