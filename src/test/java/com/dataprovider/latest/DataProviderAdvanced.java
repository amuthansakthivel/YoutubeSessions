package com.dataprovider.latest;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAdvanced {
	public static List<Map<String,String>> smalllist= new ArrayList<>();
	
	@Test(dataProvider="getData")
	public void test1(Map<String,String> data) {
		data.forEach((k,v)->System.out.println(k+":"+v));
	}

	@Test(dataProvider="getData")
	public void test2(Map<String,String> data) {
		data.forEach((k,v)->System.out.println(k+":"+v));
	}

	
	@DataProvider
	public static Object[] getData(Method m) throws IOException {
		String testname = m.getName();
		if(smalllist.isEmpty()) {
			smalllist =readExcelAndStoreInMap();
		}
		List<Map<String,String>> list = new ArrayList<>();
		for(int i=0;i<smalllist.size();i++) {
			if(smalllist.get(i).get("testname").equalsIgnoreCase(testname)) {
				list.add(smalllist.get(i));
			}
		}
		smalllist.removeAll(list);
		
		return list.toArray();
	}


	private static List<Map<String, String>> readExcelAndStoreInMap() throws IOException {
		FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+"/excel/testdata.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		XSSFSheet sheet =workbook.getSheet("Sheet1");
		String sheetname = "Sheet1";
		
		Map<String,String> datamap = null;
		List<Map<String,String>> list = new ArrayList<>();
		
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			datamap = new HashMap<>();
			for(int j=0;j< sheet.getRow(0).getLastCellNum();j++) {
				String key = getCellContent(workbook,sheetname, 0, j);
				String value = getCellContent(workbook,sheetname, i, j);
				datamap.put(key, value);
			}
			list.add(datamap);
		}
		
		return list;
		
	}

	private  static String getCellContent(XSSFWorkbook workbook,String sheetname,int rownum, int colnum) {
		return workbook.getSheet(sheetname).getRow(rownum).getCell(colnum).getStringCellValue();
	}


	
}
