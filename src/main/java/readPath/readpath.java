package readPath;

public class readpath {


	public static String fetchpathDynamically() {
		//D:\\eclipse\\Batch51_Cusip\\driverDetails\\chromedriver.exe
	
		String path = System.getProperty("user.dir"); 
		
		return path;
	}
}
