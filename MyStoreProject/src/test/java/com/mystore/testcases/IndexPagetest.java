package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPagetest extends BaseClass {
	
	IndexPage index;
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups="smoke")
	public void verifyLogo() {
		index =new IndexPage();
		boolean result=index.validateLogo();
		Assert.assertTrue(result);
	}
	
	

}
