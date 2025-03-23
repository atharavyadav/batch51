package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class com_testcase_mousehover {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_mousehover.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.mousehover);
		
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{
         logger.info("excution started");
		WebElement ele = driverIntializer.driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		 logger.info("mousehover");
		Actions act = new Actions(driverIntializer.driver);
		 logger.info("mousehover completed");
		act.moveToElement(ele).build().perform();
	}
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
	
	}
}
