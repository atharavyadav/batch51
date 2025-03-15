package TestCases;

import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import asserstion.assertfunctions;
import driverIntializer.driverIntializer;
import readDataFromExcel.excelReader;
import reusableData.resusebaleData;
import seleniumActions.seleniumUIActions;

public class com_testcase_verifyAlert {


	private static final Logger logger = LogManager.getLogger(com_testcase_registerpage.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.alerturl);
		
		
	}
	

	@Test(priority = 1)
	public void handleAert() throws IOException
	{
       driverIntializer.driver.findElement(By.xpath("//button[@id='alertBox']")).click();
       seleniumUIActions.handleAlert("yes");
		
	}		

	@Test(priority = 2)
	public void enterMessageInalert() throws IOException
	{
       driverIntializer.driver.findElement(By.xpath("//button[@id='promptBox']")).click();
       seleniumUIActions.handleAlertwithMessage("yes","neelam");
		
	}
	
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
