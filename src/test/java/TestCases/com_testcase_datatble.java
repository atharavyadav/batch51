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

public class com_testcase_datatble {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_datatble.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.dataTable);
		
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{
		List <WebElement> rows = driverIntializer.driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
		for (int i = 1; i < rows.size(); i++) {	
		List <WebElement> column = driverIntializer.driver.findElements(By.xpath("//table[@class='dataTable']//tr["+i+"]//td"));	
	     for (int j = 0; j < column.size(); j++) {
	    	 if(i==5)
	    	 {
	    		 String data = column.get(j).getText();
		    	 System.out.println(data);
	    	 }
	    	 
		}
		 
		}
	}
	
	
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
