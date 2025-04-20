
package driverIntializer;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import reusableData.resusebaleData;

public class driverIntializer {
private static final Logger logger = LogManager.getLogger(driverIntializer.class);
public static WebDriver driver;
public static String downloadFilePath = System.getProperty("user.dir") + "\\downloads";
 public static void launchdriver(String url) {

	 Map<String, Object> prefs = new HashMap<>();
     prefs.put("download.default_directory", downloadFilePath); // Set download directory
     prefs.put("download.prompt_for_download", false); // Disable "Save As" dialog
     prefs.put("safebrowsing.enabled", true); // Enable safe browsing

	 ChromeOptions options = new ChromeOptions();
	 //options.addArguments("--headless");
	 options.setExperimentalOption("prefs", prefs);
  if (resusebaleData.browserCateogry.equals("chrome")) {
   System.setProperty(resusebaleData.chromedriverType, resusebaleData.chromedriverPath);
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
   driver.get(url);
   logger.info("User is on the Register Page with URL Used is :=>"+resusebaleData.url);
  } else if(resusebaleData.browserCateogry.equals("edge")) {
   System.setProperty(resusebaleData.edgedriverType, resusebaleData.edgedriverPath);
    driver = new EdgeDriver();
    driver.manage().window().maximize();
   driver.get(url);
   logger.info("User is on the Register Page with URL Used is :=>"+resusebaleData.url);
  } else {
	  logger.info("invalid browser type");
  }

 }
 
 public static void closebrowser()
 {
	 driver.quit();
 }

}
