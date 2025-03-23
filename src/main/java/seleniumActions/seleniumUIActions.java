package seleniumActions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import driverIntializer.driverIntializer;
import readerUtils.readDataFromPeropertiesFile;
import reusableData.resusebaleData;

//Author:Neelam
public class seleniumUIActions {
	private static final Logger logger = LogManager.getLogger(seleniumUIActions.class);
	
//	this function is used to enter the value in UI and accepts 3 paramters 
//	1 is for OR path , 2 is which key u wnat to give for xpath , 3 is value u want to enter
	public static void enterValueinUI(String ORPath,String ORKey,String inputData) throws IOException
	{
		    int val = 4;
		   String convert = Integer.toString(val) ;
		   System.out.println(convert);
		driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(ORPath,ORKey))).sendKeys(inputData);
		
	}
	
	public static void click(String ORPath,String ORKey) throws IOException
	{
		driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(ORPath,ORKey))).click();
		
	}

	public static void selectDropdownValue(String xpath , String value) throws IOException
	{		
		WebElement ele = driverIntializer.driver.findElement(By.xpath(readDataFromPeropertiesFile.readDataFromORProperties(resusebaleData.regiterORPath, xpath)));
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	public static void takescreenshot(String screenshotname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driverIntializer.driver;//take screenshot from UI
		File file = ts.getScreenshotAs(OutputType.FILE);//convert to 1 type of common file
		FileUtils.copyFile(file, new File("D:\\eclipse\\Batch51_Cusip\\TestEvidences\\"+screenshotname+".png"));
		
	}
	
	public static String getTextfromUI(String xpathofUI , String splitRequired) throws IOException
	{
	
		String username = driverIntializer.driver.findElement(By.xpath(xpathofUI)).getText();
		
		if (splitRequired.equalsIgnoreCase("Yes")) {
			String[] splitusername= username.split(" ");
			String usernamefetchedfromUI = splitusername[splitusername.length-1];
			usernamefetchedfromUI=usernamefetchedfromUI.replaceAll("[^0-9a-z]", "");
			return usernamefetchedfromUI;
		} else {
            
			return username;
			
		}	
	
	}
	
	
	public static void handleAlert(String alertType)
	{
		
		Alert alert = driverIntializer.driver.switchTo().alert();
		 String alertmsg = 	alert.getText();
	      logger.info("alert message is " + alertmsg);   
	      
		if (alertType=="yes") {
			alert.accept();
			logger.info("alert is accepted");
		} 
		else if(alertType=="No") {
			alert.dismiss();
			logger.info("alert is dismissed");
		}
		else {
			logger.info("User is not intrested in handling alert , please comntinue");
		}
		
	}
	
	public static void handleAlertwithMessage(String alertType,String alertMessage)
	{
		
		Alert alert = driverIntializer.driver.switchTo().alert();
		 String alertmsg = 	alert.getText();
	      logger.info("alert message is " + alertmsg);   
	      alert.sendKeys(alertMessage);
	      
		if (alertType=="yes") {
			alert.accept();
			logger.info("alert is accepted");
		} 
		else if(alertType=="No") {
			alert.dismiss();
			logger.info("alert is dismissed");
		}
		else {
			logger.info("User is not intrested in handling alert , please comntinue");
		}
		
	}

	
	public static void framehandling(String frameID , String framexpath)
	{
		   driverIntializer.driver.switchTo().frame(frameID);
	       driverIntializer.driver.findElement(By.xpath(framexpath)).click();
	       //
	}
}
