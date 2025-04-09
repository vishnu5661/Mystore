package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//img[contains(@title, 'Faded')]")
	WebElement productResult;
	
	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="(//a[@title='Dresses'][normalize-space()='Dresses'])[2]")
	WebElement dresseBtn;	
	
	@FindBy(xpath="//a[@id='color_22']")
	WebElement availableProduct;
	
	@FindBy(xpath="//a[@id='color_11']")
	WebElement selectBlackOpt;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(getDriver(), productResult);
		
	}
	
	public AddToCartPage addAvilableProduct() throws Exception {
		Action.click(getDriver(), dresseBtn);
		Action.click(getDriver(), availableProduct);
		Action.waitTillElementDisplay(getDriver(), selectBlackOpt);
		Action.click(getDriver(), selectBlackOpt);
		Action.click(getDriver(), selectBlackOpt);
		//Action.scrollByVisibilityOfElement(getDriver(), addToCartBtn);
		Action.waitTillElementDisplay(getDriver(), addToCartBtn);
		Action.click(getDriver(), addToCartBtn);
		Thread.sleep(1000);
		return new AddToCartPage();
	}
	
	

}
