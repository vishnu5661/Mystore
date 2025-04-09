package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;

	@FindBy(xpath="//img[@alt='My Shop']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchproductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		//signInBtn.click();
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return Action.isDisplayed(getDriver(), myStoreLogo);
		
	}
	
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchproductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
	
	
}
