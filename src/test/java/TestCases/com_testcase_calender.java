package TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class com_testcase_calender {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_calender.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.calender);
		
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{
		
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = today.format(formatter);
        System.out.println(formattedDate);
        //05-Apr-2025
        //
		  By inputField = By.xpath("//input[@id='onward_cal']");
		    JavascriptExecutor js = (JavascriptExecutor) driverIntializer.driver;
		    js.executeScript("arguments[0].value='05-Apr-2025';", driverIntializer.driver.findElement(inputField));
	}
	
	
	@AfterTest
	public void  closeBrowser()
	{
		//driverIntializer.closebrowser();
		
	}
}
