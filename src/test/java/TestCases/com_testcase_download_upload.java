package TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
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

public class com_testcase_download_upload {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_download_upload.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.downloadUrl);
		
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{
//	     String path = System.getProperty("user.dir") + "\\uploadtestdata\\dummy.txt";
//		 driverIntializer.driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys(path);
		
		driverIntializer.driver.findElement(By.xpath("//a[@id='downloadButton']")).click();
	}
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
