package com.FreeCrm.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.FreeCrm.qa.Base.TestBase;

public class TestUtil extends TestBase
{
	static Workbook workbook;
	static String filepath="D:/eclipse/FreeCRMAPP/src/main/java/com/FreeCrm/qa/TestData/FreeCrm_Data.xlsx";
	static Sheet sheet;

	public TestUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long Page_Load_Timeout = 40;
	public static long Implicit_wait = 20;
	
	public void SwitchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

	public static Object [][] GetTestData(String sheetname)
	{
		FileInputStream file = null;
		try {
			 file = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			try {
				workbook = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = workbook.getSheet(sheetname);
		
		Object [][] data = new  Object[sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum() ; i++) 
		{
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) 
			{
				
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		
		return data;
		
		
		
	}
	
	
}
