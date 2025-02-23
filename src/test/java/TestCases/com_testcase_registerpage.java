package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverIntializer.driverIntializer;
import readerUtils.readDataFromPeropertiesFile;
import reusableData.resusebaleData;

public class com_testcase_registerpage {
	
	
	@BeforeTest
	public void registerPageNavigation()
	{
		driverIntializer.launchdriver(resusebaleData.url);
	}

	@Test
	public void enterContactInformation() throws IOException
	{
		driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(resusebaleData.regoterORPath, "Register.ContactInformation.FirstName.input"))).sendKeys("neelam");
		driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(resusebaleData.regoterORPath, "Register.ContactInformation.LastName.input"))).sendKeys("test");
	}
}
