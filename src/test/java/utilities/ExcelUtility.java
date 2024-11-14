package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String Path;

	public ExcelUtility(String path) {
		this.Path = path;

	}

	public int getRowCount(String sheetname) throws IOException {
		fi = new FileInputStream(Path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetname);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public int getCellCount(String sheetname,int rownum)throws IOException
	{
		fi=new FileInputStream(Path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
	    int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	
	
	public String getCellData(String sheetname, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(Path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
	    
		DataFormatter formatter =new DataFormatter();
		String data;
		try {
			data =formatter.formatCellValue(cell);  //Returns the formatted value of a cell as a String regardless
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public void setCellData(String sheetname,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(Path);
		if(!xlfile.exists()) // If file not exits then create new file
		{
			wb=new XSSFWorkbook();
			fo=new FileOutputStream(Path);
			wb.write(fo);
			
		}
		
		fi=new FileInputStream(Path);
		wb=new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(sheetname)==-1)  //If sheet not exists then create new Sheet
			wb.createSheet(sheetname);
		ws=wb.getSheet(sheetname);
		
		if(ws.getRow(rownum)==null) //If sheet not exists then create new Row
			ws.createRow(rownum);
		row=ws.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(Path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		}
		
		
	public void fillGreenColor(String sheetname,int rownum,int colnum)throws IOException
	{
		fi=new FileInputStream(Path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	
	public void fillRedColor(String sheetname,int rownum,int colnum)throws IOException
	{
		fi=new FileInputStream(Path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
}	
		
		
		
//		
//		
//	File src = new File(System.getProperty("user.dir") + "//src//test//java//TestData//filename.xlsx");
//	FileInputStream excel = new FileInputStream(src);
//
//	XSSFWorkbook workb = new XSSFWorkbook(excel);
//
//	// load the sheet from above excel workbook
//	XSSFSheet sheet = workb.getSheetAt(sheetind);
//
//	// how many total rows in my excel sheet
//	int rowCount = sheet.getLastRowNum();
//
//	int cellCount = sheet.getRow(0).getLastCellNum();
//
//	Object[][] testdata = new Object[rowCount][cellCount];
//
//	for(
//	int i = 1;i<rowCount+1;i++)
//	{
//		Row r = sheet.getRow(i);
//
//		for (int j = 0; j < cellCount; j++) {
//			testdata[i - 1][j] = r.getCell(j).getStringCellValue().toString();
//			System.out.println(testdata[i - 1][j] = r.getCell(j).getStringCellValue().toString());
//		}
//	}
//
//	return testdata;
//}}
