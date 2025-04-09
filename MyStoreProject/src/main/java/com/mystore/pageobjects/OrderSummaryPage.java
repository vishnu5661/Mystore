package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{
	
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	WebElement confirmOrderBtn;
	
	public OderConfirmationPage clickOnConfirmOrderBtn() {
		Action.click(getDriver(), confirmOrderBtn);
		return new OderConfirmationPage();

	}

}
