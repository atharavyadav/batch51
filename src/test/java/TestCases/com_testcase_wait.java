package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class com_testcase_wait {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_wait.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.waittUrl);
	
		
	}

	@Test
	public void enterContactInformation() throws IOException, InterruptedException
	{
		//implicit wait or hard wait 
		//explicit wait or soft wait 
		//fluent wait --- not inuse anymore
		driverIntializer.driver.findElement(By.xpath("//button[@id='btn1']")).click();
		//Thread.sleep(10000); use when u dont have any options
		seleniumUIActions.implicitWait(10);
		driverIntializer.driver.findElement(By.xpath("(//input[@placeholder='Textbox1'])[1]")).sendKeys("test");
		
//		WebDriverWait wait = seleniumUIActions.ExplicitWait(10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(null));
	
	}
	
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
