package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
@DataProvider(name="LoginData")
public String[][] getData() throws IOException
{
	 String path=".\\testData\\sincxapp_logindata.xlsx";   //taking xl file from testdata
	 
	 ExcelUtility xlutil=new ExcelUtility(path);   //Creating an object for XLUtitlity
	 
	 int totalrows=xlutil.getRowCount("Sheet1"); 
	 int totalcols=xlutil.getCellCount("Sheet1", 1);
	 
	 String logindata[][]=new String[totalrows][totalcols];   //Created for two dimensional array which can store
	 
	 for(int i=1;i<=totalrows; i++)//1   //read the data from xl storing in two dimensional
	 {
		 for(int j=0;j<totalcols;j++)  //0  i is rows j is col
		 {
			logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
		 }
	 }	 
		 return logindata; 
			  //returning two dimension array
	 }


//@DataProvider(name = "excelData")
//public Object[][] provideData() {
//    try {
//        return XLUtilites.getExcelData(".\\testData\\sincxapp_logindata.xlsx", "Sheet1");
//    } catch (IOException e) {
//        e.printStackTrace();
//        return new Object[][]{};
//    }
//
//	
//}
	
}


//DataProvider 2














	
	
	
// String path=".\\testData\\sincxapp_logindata.xlsx";   //taking xl file from testdata
// 
// ExcelUtility xlutil=new ExcelUtility(path);   //Creating an object for XLUtitlity
// 
// int totalrows=xlutil.getRowCount("Sheet1"); 
// int totalcols=xlutil.getCellCount("Sheet1", 1);
// 
// String logindata[][]=new String[totalrows][totalcols];   //Created for two dimensional array which can store
// 
// for(int i=1;i<=totalrows; i++)//1   //read the data from xl storing in two dimensional
// {
//	 for(int j=0;j<totalcols;j++)  //0  i is rows j is col
//	 {
//		logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
//	 }
// }	 
//	 return logindata; 
//		  //returning two dimension array
// }

//DataProvider 2
 
 
//DataProvider 3 



