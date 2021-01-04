package com.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {
	
//	@Test(dataProvider="getData")
	public void testWithExcel(String username,String password , String fname, String lname) {
		System.out.println(username);
	}

	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/excel/testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	@Test(dataProvider="getDataWithTable")
	public void testWithExcelAndTable(Map<String,String> data) {
		System.out.println(data.get("username"));
	}

	@DataProvider(parallel = true)
	public Object[] getDataWithTable() throws IOException {
		
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/excel/testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		
		Object[] data = new Object[sheet.getLastRowNum()];
		
		Map<String,String> table;
		
		for(int i=1; i<=sheet.getLastRowNum(); i++) {
			table = new HashMap<>();
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				table.put(key, value);
				data[i-1] = table;
			}
		}
		return data;
	}
}
