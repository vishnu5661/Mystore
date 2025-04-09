package com.mystore.utility;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ExtentManager {
		
		public static ExtentSparkReporter reporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		@BeforeSuite
		public static void setExtent() throws Exception {
			reporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+Action.getCurrentTime()+".html");
			//reporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
			reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			//htmlReporter.config().setDocumentTitle("Automation Test Report");
			//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
			//htmlReporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			
			extent.setSystemInfo("HostName", "MyHost");
			extent.setSystemInfo("ProjectName", "MyStoreProject");
			extent.setSystemInfo("Tester", "Vishnu");
			//extent.setSystemInfo("OS", "Win10");
			extent.setSystemInfo("Browser", "Chrome");
		}
		
		@AfterSuite
		public static void endReport() {
			extent.flush();
		}
	}



