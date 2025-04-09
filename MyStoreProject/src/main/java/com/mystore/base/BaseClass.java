package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

public class BaseClass {
	
	public static Properties prop;
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	//comment from git repo.
	@BeforeSuite(groups={"smoke","sanity","Regression"})
	public void loadConfig() throws Exception {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@Parameters("browser")
	public void launchApp(String browser) {
		//WebDriverManager.chromedriver().setup();
		//String browserName = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
		}else if (browser.equalsIgnoreCase("Firefox")) {
			driver.set(new FirefoxDriver());
		}else if (browser.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
		}
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().manage().window().maximize();
		

		getDriver().get(prop.getProperty("url"));
		
	}

	
	 
	 
	
	@AfterMethod(groups={"smoke","sanity","Regression"})
	public void teardown() {
		getDriver().close();
		//driver.quit();
		
	}
	@AfterSuite(groups={"smoke","sanity","Regression"})
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
