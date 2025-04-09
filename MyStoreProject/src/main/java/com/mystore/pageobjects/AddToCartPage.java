package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addtocartBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addTocartMessage;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	WebElement proceedtoCheckOutBtn;
	
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String qty) {
		Action.type(quantity, qty);
	}
	
	public void selectSize(String size1) {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddTocart() {
		Action.click(getDriver(), addtocartBtn);
		
	}
	
	public boolean validateAddtocart() {
		Action.waitTillElementDisplay(getDriver(), addTocartMessage);
		String msg=addTocartMessage.getText();
		System.out.println(msg);
		return Action.isDisplayed(getDriver(), addTocartMessage);
		
	}
	
	public OrderPage clickOnCheckOut() {
		Action.JSClick(getDriver(), proceedtoCheckOutBtn);
		return new OrderPage();
	}

}
