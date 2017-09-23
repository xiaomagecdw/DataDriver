package com.frame.testScripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frame.appModules.Login_Action;
import com.frame.pageObjects.LoginPage;

public class TestMailLogin {
	
	public WebDriver driver;
	String baseUrl = "http://mail.126.com/";
	
	@Test
	public void testMailLogin() throws Exception{
		
		Login_Action.execute(driver, "cdw520xxy", "cdw520xxy1314");
		/*driver.get(baseUrl+"/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName().sendKeys("cdw520xxy");
		loginPage.password().sendKeys("cdw520xxy1314");
		loginPage.loginButton().click();*/
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.getPageSource().contains("未读邮件"));
		
	}
	
	@BeforeMethod
	public void beforeMethod(){
		
		DOMConfigurator.configure("log4j.xml");
//		设定浏览器启动文件绝对路径
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}

}
