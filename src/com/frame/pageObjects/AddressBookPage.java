package com.frame.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frame.uitl.ObjectMap;

public class AddressBookPage {
	
	private WebElement element = null;
	private WebDriver driver;
	private ObjectMap objectMap = new ObjectMap("/objectMap.properties");
	
	public AddressBookPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement createContactPresonbutton() throws Exception{
		
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.createContactPreson"));
		return element;
	}
	
	public WebElement contactPresonName()throws Exception{
		
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.contactPresonName"));
		return element;
	}
	
	public WebElement contactPresonEmail() throws Exception{
		
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.contactPresonEmail"));
		return element;
	}
	
	public WebElement contactPresonMoblie() throws Exception{
		
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.contactPrsonMoblie"));
		return element;
	}
	
	public WebElement saveButton()throws Exception{
		
		element = driver.findElement(objectMap.getLocator("126mail.addressBook.saveButton"));
		return element;
	}

}
