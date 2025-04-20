package API_TestCases;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestCases.com_testcase_calender;
import driverIntializer.driverIntializer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reusableData.resusebaleData;
import seleniumActions.seleniumAPIActions;
import seleniumActions.seleniumUIActions;

public class com_API_testcase_createUser {
private static final Logger logger = LogManager.getLogger(com_testcase_calender.class);
	
	
	@Test
	public void enterContactInformation() throws IOException
	{
		Response postdata =    seleniumAPIActions.execute_PostRequest(seleniumAPIActions.readJsonFile(System.getProperty("user.dir")+"\\API_TestData\\createUser_PostData.json"), resusebaleData.RESTAPI_URL+resusebaleData.PostReq_Endpoint);
		logger.info("My status code for post req is " + postdata.statusCode());
		logger.info("My status body for post req is " + postdata.getBody().asPrettyString());
	

		
	}
	
	
}
