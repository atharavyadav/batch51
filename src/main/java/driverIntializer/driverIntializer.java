
package driverIntializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import reusableData.resusebaleData;

public class driverIntializer {

public static WebDriver driver;
	
 public static void launchdriver(String url) {

  if (resusebaleData.browserCateogry.equals("chrome")) {
   System.setProperty(resusebaleData.chromedriverType, resusebaleData.chromedriverPath);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
   driver.get(resusebaleData.url);
  } else if(resusebaleData.browserCateogry.equals("edge")) {
   System.setProperty(resusebaleData.edgedriverType, resusebaleData.edgedriverPath);
    driver = new EdgeDriver();
    driver.manage().window().maximize();
   driver.get(url);
  } else {
   System.out.println("Invalid browser Type");
  }

 }
 
 public static void closebrowser()
 {
	 driver.quit();
 }

}
