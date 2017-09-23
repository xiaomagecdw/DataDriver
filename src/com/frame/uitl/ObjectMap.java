package com.frame.uitl;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;

public class ObjectMap {
	
	Properties properties;
	
	public ObjectMap(String propFile){
		
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(propFile);
			properties.load(in);
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("都要去对象文件错误！");
			e.printStackTrace();
		}
	}
	
	
    public By getLocator(String ElementNameInproFile)throws Exception{
    	
//    	根据变量ElementNameInproFile，从属性配置文件中读取对应的配置对象
    	String locator= properties.getProperty(ElementNameInproFile);
//    	将配"UTF-8置对象中的定位类型存到locatorType变量，将定位表达式的值存入locatorvalue变量
    	String locatorType = locator.split(">")[0];
    	String locatorValue = locator.split(">")[0];
      /*在eclipse中的配置文件均默认为ISO-8859-1编码存储，使用getBytes方法可以将字符串编码转换
       *为UTF-8编码，以此来解决在配置文件读取中文为乱码的问题
       */
    	locatorValue = new String(locatorValue.getBytes("ISO-8859-1"), "UTF-8");
//    	输出locatorType变量值好人locatorValue变量值，验证是否赋值正确
    	System.out.println("获取的定位类型："+locatorType+ "\t获取的定位表达式："+locatorValue);
//    	根据locatorType的变量之内容判断返回何种定位方式的B有对象
    	if(locatorType.toLowerCase().equals("id"))
    		return By.id(locatorValue);
    	else if(locatorType.toLowerCase().equals("name"))
    		return By.name(locatorValue);
    	else if(locatorType.toLowerCase().equals("classname"))
    		return By.className(locatorValue);
    	else if(locatorType.toLowerCase().equals("tagname"))
    		return By.tagName(locatorValue);
    	else if(locatorType.toLowerCase().equals("linktext"))
    	    return By.linkText(locatorValue);
    	else if(locatorType.toLowerCase().equals("partiallinktext"))
    		return By.partialLinkText(locatorValue);
    	else if(locatorType.toLowerCase().equals("cssselector"))
    		return By.cssSelector(locatorValue);
    	else if(locatorType.toLowerCase().equals("xpath"))
    		return By.xpath(locatorValue);
    	else 
    		throw new Exception("输入的locatorType未在程序中被定义："+locatorValue);
    }      
}
