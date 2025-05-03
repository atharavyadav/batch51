package API_TestCases;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestCases.com_testcase_calender;
import driverIntializer.driverIntializer;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reusableData.resusebaleData;
import seleniumActions.seleniumAPIActions;
import seleniumActions.seleniumUIActions;

public class com_API_testcase_createUser {
private static final Logger logger = LogManager.getLogger(com_testcase_calender.class);
static String keyofcookies = "";
	

@BeforeTest
public  void captureAutherizationData() throws IOException
{
	Response postdata =    seleniumAPIActions.execute_PostRequestforAtherization(seleniumAPIActions.readJsonFile(System.getProperty("user.dir")+"\\API_TestData\\AuthToken.json"), resusebaleData.RESTAPI_URL+resusebaleData.PostReq_Endpoint);
	logger.info("My status code for post req is " + postdata.statusCode());
	logger.info("My status body for post req is " + postdata.getBody().asPrettyString());
	Map<String, String> cookies = postdata.getCookies();
	 keyofcookies = cookies.get("cookieskeys");
	
	
}

	@Test(priority = 1)
	public Response executePOSTReq() throws IOException
	{	
		Response postdata =    seleniumAPIActions.execute_PostRequest(seleniumAPIActions.readJsonFile(System.getProperty("user.dir")+"\\API_TestData\\createUser_PostData.json"), resusebaleData.RESTAPI_URL+resusebaleData.PostReq_Endpoint,keyofcookies);
		logger.info("My status code for post req is " + postdata.statusCode());
		logger.info("My status body for post req is " + postdata.getBody().asPrettyString());
		return postdata;
		
	}

	@Test(priority = 2)
	public Response executeGETReq() throws IOException
	{
		JsonPath js  = executePOSTReq().jsonPath();
		String id = js.getString("id");
		Response getdata =    seleniumAPIActions.execute_GETRequest(resusebaleData.RESTAPI_URL+resusebaleData.PostReq_Endpoint+ "/"  + id,keyofcookies );
		logger.info("My status code for get req is " + getdata.statusCode());
		logger.info("My status body for get req is " + getdata.getBody().asPrettyString());
		return getdata;
	}
	
	@Test(priority = 3)
	public void assertData() throws IOException
	{
		JsonPath js  = executeGETReq().jsonPath();
		String name = js.getString("name");
		Assert.assertEquals(name, "Apple MacBook Pro 16");
		
		String CPUmodel = js.getString("CPU model");
		Assert.assertEquals(CPUmodel, "Intel Core i9");




	}
}
