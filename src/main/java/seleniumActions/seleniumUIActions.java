package seleniumActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	public static void click(String ORPath,String ORKey,String inputData) throws IOException
	{
		driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(ORPath,ORKey))).sendKeys(inputData);
		
	}

	public static void selectDropdownValue(String xpath , String value) throws IOException
	{		
		WebElement ele = driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(resusebaleData.regiterORPath, xpath)));
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	
}
