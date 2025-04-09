package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultpage;
	AddToCartPage addTocartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	@Test(groups="Regression")
	public void verifyTotalPrice() throws Exception {
		indexPage=new IndexPage();
		loginPage=new LoginPage();
		homePage=new HomePage();
		searchResultpage=new SearchResultPage();
		
		searchResultpage=indexPage.searchProduct("t-Shirt");
		addTocartPage=searchResultpage.addAvilableProduct();
		orderPage=addTocartPage.clickOnCheckOut();
		double unitPrice=orderPage.getUnitPrice();
		System.out.println("Product Price is: "+unitPrice);
		double totalPrice=orderPage.getTotalPrice();
		System.out.println("Final amount is :" + totalPrice);
		double qty=orderPage.getQty();
		System.out.println("Total quantity is :" + qty);
		double shipping=orderPage.getShippingCharges();
		System.out.println("Shipping charges are: " + shipping);
		double totalExpectedPrice=(unitPrice*1)+shipping;
		Assert.assertEquals(totalExpectedPrice, totalPrice);
		orderPage.clickOnCheckOut();
	}

}
