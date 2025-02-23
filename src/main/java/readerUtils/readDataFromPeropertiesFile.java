package readerUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readDataFromPeropertiesFile {
	
//	the below fucnction will return data based on key and value pair
	
	public static String readDataFromORProperties(String path,String keydata) throws IOException {
		
		File file = new File(path);//read the file location where u have stored
		FileInputStream input = new FileInputStream(file);//after u read the file it will load the data from the file
		Properties prop =new Properties();//it will rea data based on key value pair
		prop.load(input);
		String value = prop.getProperty(keydata);//return u the value based on the keys
		return value;
		
	}

}
