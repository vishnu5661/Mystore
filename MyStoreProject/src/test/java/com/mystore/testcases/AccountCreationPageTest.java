package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@Test(groups="sanity")
	public void verifyCreateAccountTest() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createNewAccount(prop.getProperty("newaccountmail"));
		boolean accountPage=accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(accountPage);
		
	}
}
