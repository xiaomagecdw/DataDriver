package com.frame.appModules;

import org.openqa.selenium.WebDriver;

import com.frame.pageObjects.LoginPage;

public class Login_Action {
	
	public static void execute(WebDriver driver,String userName, String passWord) throws Exception{
		
		driver.get("http://mail.126.com");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName().sendKeys(userName);
		loginPage.password().sendKeys(passWord);
		loginPage.loginButton().clear();
		Thread.sleep(5000);
	}

}
