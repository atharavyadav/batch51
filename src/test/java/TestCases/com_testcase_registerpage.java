package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverIntializer.driverIntializer;
import readDataFromExcel.excelReader;
import readerUtils.readDataFromPeropertiesFile;
import reusableData.resusebaleData;
import seleniumActions.seleniumUIActions;

public class com_testcase_registerpage {
	
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.url);
		
	}

	@Test
	public void enterContactInformation() throws IOException
	{

		seleniumUIActions.enterValueinUI(resusebaleData.regiterORPath, "Register.ContactInformation.FirstName.input", excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 0));
		seleniumUIActions.enterValueinUI(resusebaleData.regiterORPath, "Register.ContactInformation.LastName.input", excelReader.readTestDataFromExcel(resusebaleData.excelpath, resusebaleData.sheetname_Contact, 1, 1));
		seleniumUIActions.enterValueinUI(resusebaleData.regiterORPath, "Register.ContactInformation.phone.input", "1224");
		seleniumUIActions.takescreenshot();
	}
	
	
	@Test
	public void enterMailingInformation() throws IOException
	{
     
		seleniumUIActions.selectDropdownValue("Register.MailingInformation.country.select", "ALGERIA");
		
	}
	@AfterTest
	public void  closeBrowser()
	{
		driverIntializer.closebrowser();
		
	}
}
