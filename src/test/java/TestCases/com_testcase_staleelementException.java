package TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import asserstion.assertfunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import driverIntializer.driverIntializer;
import readDataFromExcel.excelReader;
import readerUtils.readDataFromPeropertiesFile;
import reusableData.resusebaleData;
import seleniumActions.seleniumUIActions;

public class com_testcase_staleelementException {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_staleelementException.class);
	
	@BeforeTest
	public void registerPageNavigation () throws Exception
	{
		
		driverIntializer.launchdriver(resusebaleData.anchortag);
		
//		try {
//			driverIntializer.launchdriver(resusebaleData.anchortag);
//		} catch (StaleElementReferenceException e) {
//			System.out.println(e);
//		}catch (Exception e) {
//			System.out.println(e);
//		}
		
		
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{
		List<WebElement> ele =	driverIntializer.driver.findElements(By.tagName("a"));
		System.out.println(ele.size());//92
		
		
		
		
	}
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}

	
}
