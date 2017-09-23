package com.frame.testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frame.appModules.AddContactPreson_Action;
import com.frame.uitl.Constant;
import com.frame.uitl.ExcelUitl;
import com.frame.uitl.Log;

public class TestMailAddContactPreson {
	
	private WebDriver driver;
//	调用Constant类中的常量Constant.Url
	private String baseUrl = Constant.Url;
	
//	String baseUrl = "http://mail.126.com/";
	
	@Test
	public void testAddressContactPreson()throws Exception{
		
		Log.startTestCase(ExcelUitl.getCellData(1, 0));
		driver.get(baseUrl);
		
		String mailUserName = ExcelUitl.getCellData(1, 1);
		
		String mailPassWord = ExcelUitl.getCellData(1, 2);
		
		String contactPresonName = ExcelUitl.getCellData(1, 3);
		
		String contactPresonEmail = ExcelUitl.getCellData(1, 4);
		
		String contactPresonMoblie = ExcelUitl.getCellData(1, 5);
		
		Log.info("调用AddContactPreson_Action类的execute方法");
		AddContactPreson_Action.execute(driver, mailUserName,mailPassWord, contactPresonName, contactPresonEmail,contactPresonMoblie);
		
		Log.info("调用AddContactPreson_Action类的execute方法后，休眠3秒");
		Thread.sleep(3000);
		
		Log.info("断言通讯录的页是否包含联系人的姓名关键字");
		Assert.assertTrue(driver.getPageSource().contains(contactPresonName));
		
		Log.info("断言通讯录的页是否包含联系人的点击邮箱关键字");
		Assert.assertTrue(driver.getPageSource().contains(contactPresonEmail));
		
		Log.info("断言通讯录的页是否包含联系人的手机号关键字");
		Assert.assertTrue(driver.getPageSource().contains(contactPresonMoblie));
		
		Log.info("新建联系人的全部断言成功，在excel的测试数据文件的“测试执行结果”列中写入“执行成功”");
		ExcelUitl.setCellData(1, 9, "执行成功");
		
		Log.info("测试结果成功写入Excel数据文件的“测试执行结果”列");
		Log.endTestCase(ExcelUitl.getCellData(1, 0));
		
//		第二次
		/*AddContactPreson_Action.execute(driver, Constant.MailUsername, Constant.MailPassword, 
				Constant.ContactPresonName, Constant.ContactPresonEmail, Constant.ContactPresonMoblie);
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains(Constant.ContactPresonName));
		Assert.assertTrue(driver.getPageSource().contains(Constant.ContactPresonEmail));
		Assert.assertTrue(driver.getPageSource().contains(Constant.ContactPresonMoblie));*/
		
		
//		第一次
		/*AddContactPreson_Action.execute(driver,"cdw520xxy","cdw520xxy1314","李四","lisi@sogou.com","12398907878");
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("李四"));
		Assert.assertTrue(driver.getPageSource().contains("lisi@sogou.com"));
		Assert.assertTrue(driver.getPageSource().contains("12398907878"));*/
		
	}
	@BeforeMethod
	public void beforeMethod(){
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	
	@BeforeClass
	public void beforeClass()throws Exception{
		ExcelUitl.setExcelFile(Constant.TestDataExcelFilePath, Constant.TestDataExcelSheetName);
	}
}
