package asserstion;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class assertfunctions {
	
	public static void hardassert(String actual, String expected)
	{
		Assert.assertEquals(actual,expected);//hard assert
	}
	
	public static void softassert(String actual, String expected)
	{
		SoftAssert soft = new SoftAssert();//soft assert
		soft.assertEquals(actual, expected);
	}

}
