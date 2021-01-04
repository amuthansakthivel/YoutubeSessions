package com.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {
	
	@Test
	public void test1() throws IOException {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index.html"); 
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("TMB Report");
		spark.config().setReportName("Youtube Training");
		//setup
		
		
		//create test
		ExtentTest test = extent.createTest("First Test");
		test.pass("Checking the logs");
		
		ExtentTest test1 = extent.createTest("second Test");
		test1.fail("Checking the logs in second test");
		
		
		//tearDown
		extent.flush();
		Desktop.getDesktop().browse(new File("index.html").toURI()); //open the file in the desktop default browser.
	}

}
