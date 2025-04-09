package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	double finalUnitPrice;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//li[@class='price special-price']")
	WebElement unitPrice;
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath="//span[@id='total_product_price_5_22_0']")
	WebElement qty;
	
	@FindBy(xpath="//td[@id='total_shipping']")
	WebElement shippingChrges;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOut;
	
	public double getUnitPrice() {
		Action.waitTillElementDisplay(getDriver(), proceedToCheckOut);
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice;

	}

	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice=Double.parseDouble(total);
		return finalTotalPrice;
	}
	public double getQty() {
		String quantity=qty.getText();
		quantity=quantity.replaceAll("[^a-zA-Z0-9]", "");
		//System.out.println(quantity);
		double Qty=Double.parseDouble(quantity);
		double Quantity=Qty/finalUnitPrice;
		return Quantity;
	}
	
	public double getShippingCharges() {
		String shipcharge=shippingChrges.getText();
		String charge=shipcharge.replaceAll("[^a-zA-Z0-9]", "");
		double finalShippingCharges=Double.parseDouble(charge);
		return finalShippingCharges;
	}
	
	public LoginPage clickOnCheckOut() {
		Action.scrollToEndOfPage(getDriver());
		Action.waitTillElementDisplay(getDriver(), proceedToCheckOut);
		Action.click(getDriver(), proceedToCheckOut);
		
		return new LoginPage();
	}
	
	

	

}
