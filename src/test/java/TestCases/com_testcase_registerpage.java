package TestCases;

import java.io.IOException;
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

public class com_testcase_registerpage {
	
	private static final Logger logger = LogManager.getLogger(com_testcase_registerpage.class);
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.url);
		
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{

		logger.info("***************This Steps included adding the data for ContactInformation***************");
		logger.info("User enters Firstname and the Xpath is" + excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 0));
		seleniumUIActions.enterValueinUI(resusebaleData.regiterORPath, "Register.ContactInformation.FirstName.input", excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 0));
		logger.info("User enters lastname and the Xpath is" + excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 1));
		seleniumUIActions.enterValueinUI(resusebaleData.regiterORPath, "Register.ContactInformation.LastName.input", excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 1));
		logger.info("User enters phone and the Xpath is" + excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 0));
		seleniumUIActions.enterValueinUI(resusebaleData.regiterORPath, "Register.ContactInformation.phone.input", "1224");
		logger.info("***************This Steps ended for ContactInformation***************");
	}
	
	
	@Test
	public void enterMailingInformation() throws IOException
	{
     
		seleniumUIActions.selectDropdownValue("Register.MailingInformation.country.select", "ALGERIA");
		String name = excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 0);
		Random random = new Random();
        int randomNumber = random.nextInt(1000); // Generates a random number between 0 and 999
        String result =name +  randomNumber;//neelam455
        System.out.println(result);
		driverIntializer.driver.findElement(By.xpath("//input[@name='email']")).sendKeys(result);
		driverIntializer.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1234");
		driverIntializer.driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("1234");		
		driverIntializer.driver.findElement(By.xpath("//input[@name='submit']")).click();
		String username = seleniumUIActions.getTextfromUI("//b[contains(text(),'Your user name is')]", "Yes");
		System.out.println("the value fetched from UI" + username);
		assertfunctions.hardassert(username, result);
		
		
		
	}
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
