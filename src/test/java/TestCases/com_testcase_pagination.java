package TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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

public class com_testcase_pagination {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_pagination.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.pagination);
		
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{
		
		List <WebElement> ele =driverIntializer.driver.findElements(By.xpath("(//nav[@id='pagination'])[1]//li"));
		System.out.println("total size of the pages is" + ele.size());
		for (int i = 0; i < ele.size(); i++) {
			String pageno = ele.get(i).getText();
			System.out.println("page vallue" + pageno);
			if(pageno.equals("…"))
			{
				System.out.println("the eindex is " + i);
				ele.get(i-1).click();
			}
		}
	}
	
	
	@AfterTest
	public void  closeBrowser()
	{
		//driverIntializer.closebrowser();
		
	}
}
