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

public class com_testcase_verifyframe {


	private static final Logger logger = LogManager.getLogger(com_testcase_registerpage.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.switchtoframeurl);
		
		
	}
	

	@Test(priority = 1)
	public void handleframe() throws IOException
	{
		seleniumUIActions.framehandling(resusebaleData.Demo_Guru_FrameName, "//img[@src='Jmeter720.png']");
		
	}		

	
	
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
