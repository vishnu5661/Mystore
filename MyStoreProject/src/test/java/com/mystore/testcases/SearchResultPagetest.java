package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPagetest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultpage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups="smoke")
	public void productAvailabilityTest() {
		indexPage=new IndexPage();
		searchResultpage=indexPage.searchProduct("t-Shirt");
		boolean result=searchResultpage.isProductAvailable();
		Assert.assertTrue(result);
		
	}
	
	
}
