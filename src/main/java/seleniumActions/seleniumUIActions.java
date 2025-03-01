package seleniumActions;

import java.io.IOException;

import org.openqa.selenium.By;

import driverIntializer.driverIntializer;
import readerUtils.readDataFromPeropertiesFile;
import reusableData.resusebaleData;

//Author:Neelam
public class seleniumUIActions {
	
//	this function is used to enter the value in UI and accepts 3 paramters 
//	1 is for OR path , 2 is which key u wnat to give for xpath , 3 is value u want to enter
	public static void enterValueinUI(String ORPath,String ORKey,String inputData) throws IOException
	{
		driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(ORPath,ORKey))).sendKeys(inputData);
		
	}

}
