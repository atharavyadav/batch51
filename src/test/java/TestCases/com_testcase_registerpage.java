package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverIntializer.driverIntializer;
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

		seleniumUIActions.enterValueinUI(resusebaleData.regiterORPath, "Register.ContactInformation.FirstName.input", "naeelam");
		
	}
}
