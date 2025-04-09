package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.IndexPage;

public class LoginPageTest extends BaseClass {
	
	IndexPage index;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups= {"smoke", "sanity"})
	public void loginTest(String uname, String pswd) {
		index=new IndexPage();
		loginPage=index.clickOnSignIn();
		homePage=loginPage.login(uname, pswd);
		String actualURL=homePage.getCurrentURL();
		loginPage.signOutBtn();
		//Assert.assertEquals(actualURL, prop.getProperty("homepageurl"));
		
	}
	
}
