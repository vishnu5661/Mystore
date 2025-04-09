package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {

	SearchResultPage searchResultpage;
	IndexPage indexPage;
	AddToCartPage addTocartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups={"smoke","Regression"})
	public void addToCartTest() throws Exception {
		indexPage=new IndexPage();
		searchResultpage=indexPage.searchProduct("t-Shirt");
		addTocartPage=searchResultpage.addAvilableProduct();
		boolean result=addTocartPage.validateAddtocart();	
		Assert.assertTrue(result);
		addTocartPage.clickOnCheckOut();
		
		}
		
}

