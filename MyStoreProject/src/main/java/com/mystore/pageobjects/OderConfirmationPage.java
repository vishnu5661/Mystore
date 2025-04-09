package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OderConfirmationPage extends BaseClass{
	
	public OderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement confirmMessage;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement logOutBtn;
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessage.getText();
		return confirmMsg;
}
	public void logOut() {
		Action.click(getDriver(), logOutBtn);
	}

}
