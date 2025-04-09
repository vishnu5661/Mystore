package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultpage;
	AddToCartPage addTocartPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OderConfirmationPage orderConfirm;
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup() {
		launchApp("Chrome");
	}
	@Test(groups="Regression")
	public void endToEndTest() throws Exception {
		indexPage=new IndexPage();
		searchResultpage=indexPage.searchProduct("t-Shirt");
		addTocartPage=searchResultpage.addAvilableProduct();
		orderPage=addTocartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		boolean check=addressPage.validateDefaultAdd();
		System.out.println(check);
		if(check==false){
			addressPage.proceedToCheckOutBtn();
			
		}
		else {
			addressPage.fillAdd();
		}
		
		shippingPage=new ShippingPage();
		Thread.sleep(3000);
		//shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckout();
		//shippingPage.checkTheTerms();
		orderSummaryPage=paymentPage.clickOnPaymentmethod();
		orderConfirm=orderSummaryPage.clickOnConfirmOrderBtn();
		String Msg=orderConfirm.validateConfirmMessage();
		Assert.assertEquals(Msg, "Your order on My Shop is complete.");
		orderConfirm.logOut();
	}

}
