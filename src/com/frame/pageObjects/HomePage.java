package com.frame.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frame.uitl.ObjectMap;

public class HomePage {
	
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap("/objectMap.properties");
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		
		this.driver = driver;
	}
//	获取登录后主页面中的“通讯录”链接
	public WebElement addressLink() throws Exception{
		element = driver.findElement(objectMap.getLocator("126mail.homePage.addressbook"));
		return element;
	}
//	如果要在HomePage页面曹组更多的链接或元素，可以根据需要自定义

}
