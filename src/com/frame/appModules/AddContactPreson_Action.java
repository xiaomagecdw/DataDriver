package com.frame.appModules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.frame.pageObjects.AddressBookPage;
import com.frame.pageObjects.HomePage;

public class AddContactPreson_Action {
	
	public static void execute(WebDriver driver, String username,String password, 
			String contactName, String contactEmail,String contactMoblie)throws Exception{
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("未读邮件"));
		HomePage homePage = new HomePage(driver);
		homePage.addressLink().click();
		AddressBookPage addressBookPage = new AddressBookPage(driver);
		Thread.sleep(3000);
		addressBookPage.createContactPresonbutton().click();
		addressBookPage.contactPresonName().click();
		addressBookPage.contactPresonEmail().click();
		addressBookPage.contactPresonMoblie().click();
		addressBookPage.saveButton().click();
		Thread.sleep(5000);
	}

}
