package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement addressField;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement cityField;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement stateField;
	
	@FindBy(xpath="//div[@class='selector']/select/option[@value='1']")
	WebElement selectCity;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement postalField;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement homePhone;

	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobilePhone;
	
	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement saveBtn;

	@FindBy(xpath="//span[normalize-space()='Update']")
	WebElement updateBtn;
	
	@FindBy(xpath="//select[@id='id_address_delivery']")
	WebElement defaultAdd;
	
	@FindBy(xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedTocheckOutBtn;
	
	public void fillAdd() {
		addressField.sendKeys("xyz");
		cityField.sendKeys("xyz");
		stateField.click();
		selectCity.click();
		postalField.sendKeys("99503");
		homePhone.sendKeys("0000000000");
		mobilePhone.sendKeys("0000000000");
		saveBtn.click();
		updateBtn.click();
		proceedTocheckOutBtn.click();
		
		
	}
	
	public boolean validateDefaultAdd() {
		return Action.isDisplayed(getDriver(), defaultAdd);
	}
	public ShippingPage proceedToCheckOutBtn() {
		Action.click(getDriver(), proceedTocheckOutBtn);
		return new ShippingPage();
	}
	
	

}
