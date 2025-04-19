package TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

import com.beust.jcommander.Parameter;

import asserstion.assertfunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import driverIntializer.driverIntializer;
import readDataFromExcel.excelReader;
import readerUtils.readDataFromPeropertiesFile;
import reusableData.resusebaleData;
import seleniumActions.seleniumUIActions;

public class com_testcase_brokenlink {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_brokenlink.class);
	

	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.anchortag);
		
		
	}

	@Test(groups = {"sanity"})
	public void enterContactInformation() throws IOException
	{
		List<WebElement> ele =	driverIntializer.driver.findElements(By.tagName("a"));
		System.out.println(ele.size());//92
		
		
		for(WebElement link:ele)
		{
			String hrefurl = link.getAttribute("href");
			if(hrefurl!=null && !hrefurl.isEmpty())
			{
				HttpURLConnection http = (HttpURLConnection)new URL(hrefurl).openConnection();
				http.setRequestMethod("HEAD");
				http.connect();
				
				int respocode = http.getResponseCode();
				if(respocode>=400)
				{
					System.out.println("my broken link is" + hrefurl + respocode);
			}
				else {
					System.out.println("proper link" + hrefurl + respocode);
				}
			}
		}
		
	}
	
	
	
	@Test(groups = {"regression or sanity"})
	public void enterContactInformation1() throws IOException
	{
		List<WebElement> ele =	driverIntializer.driver.findElements(By.tagName("a"));
		System.out.println(ele.size());//92
		
		
		for(WebElement link:ele)
		{
			String hrefurl = link.getAttribute("href");
			if(hrefurl!=null && !hrefurl.isEmpty())
			{
				HttpURLConnection http = (HttpURLConnection)new URL(hrefurl).openConnection();
				http.setRequestMethod("HEAD");
				http.connect();
				
				int respocode = http.getResponseCode();
				if(respocode>=400)
				{
					System.out.println("my broken link is" + hrefurl + respocode);
			}
				else {
					System.out.println("proper link" + hrefurl + respocode);
				}
			}
		}
		
	}
	
	
	
	@Test(groups = {"smoke"})
	public void enterContactInformation2() throws IOException
	{
		List<WebElement> ele =	driverIntializer.driver.findElements(By.tagName("a"));
		System.out.println(ele.size());//92
		
		
		for(WebElement link:ele)
		{
			String hrefurl = link.getAttribute("href");
			if(hrefurl!=null && !hrefurl.isEmpty())
			{
				HttpURLConnection http = (HttpURLConnection)new URL(hrefurl).openConnection();
				http.setRequestMethod("HEAD");
				http.connect();
				
				int respocode = http.getResponseCode();
				if(respocode>=400)
				{
					System.out.println("my broken link is" + hrefurl + respocode);
			}
				else {
					System.out.println("proper link" + hrefurl + respocode);
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
