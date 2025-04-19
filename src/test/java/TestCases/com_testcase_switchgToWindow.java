package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class com_testcase_switchgToWindow {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_switchgToWindow.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.switchtowindow);
		
		
	}

	@Test
	public void navigateToNewWindow() throws IOException
	{
	
		driverIntializer.driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();		
		//First step find the Id of the page
		String parentID = driverIntializer.driver.getWindowHandle();
		System.out.println("parent ID" + parentID);
		Set<String> child = driverIntializer.driver.getWindowHandles();
		System.out.println("child id" + child);
		
		List<String> list=new ArrayList<String>(child);
		int target=1;
		if(list.size()>target)
		{
			driverIntializer.driver.switchTo().window(list.get(2));
			System.out.println(driverIntializer.driver.getTitle());
		}
		
		
		
		
		
//		for (String windowhandle : child) {
//			if(!parentID.equals(windowhandle))
//			{
//				driverIntializer.driver.switchTo().window(windowhandle);
//				System.out.println("new child id is " + driverIntializer.driver.getTitle());
//			}
//		}
////		 
//		driverIntializer.driver.switchTo().window(parentID);
//		System.out.println("new child id is " + driverIntializer.driver.getTitle());
	}
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
