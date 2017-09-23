package com.frame.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frame.uitl.ObjectMap;

public class LoginPage {
	
	private WebElement element = null;
//	指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objectMap = new ObjectMap("/objectMap.properties");
	private WebDriver driver;
	
public LoginPage(WebDriver driver){
	
	this.driver = driver;
    }
    //返回登录页面中的用户名输入框页面元素对象
    public WebElement userName() throws Exception{
    	
//    	使用objextMap类中的getLocator方法获取配置文件中关于用户名的定位方式和表达式
    	element = driver.findElement(objectMap.getLocator("126mail.loginPage.username"));
    	return element;
    }
//    返回登录页面中的密码输入框页面元素对象
    public WebElement password() throws Exception{
    	element = driver.findElement(objectMap.getLocator("126mail.loginPage.password"));
    	return element;
    }
//    返回邓丽页面中的登录按钮页面元素对象
    public WebElement loginButton() throws Exception{
    	element = driver.findElement(objectMap.getLocator("126mail.loginPage.loginbutton"));
    	return element;
    }

}
