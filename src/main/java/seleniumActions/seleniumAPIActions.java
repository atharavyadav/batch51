package seleniumActions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reusableData.resusebaleData;

public class seleniumAPIActions {
	
	
	public static Response execute_PostRequestforAtherization(String body , String url) {
		Response postrequest = RestAssured.given().headers("content-type","application/json").
				body(body)
		.when().post(url).then().extract().response();
		return postrequest;
	}
	
	
	

	public static Response execute_PostRequest(String body , String url,String cookievalue) {
		Response postrequest = RestAssured.given().headers("content-type","application/json").
				headers("cookieskey",cookievalue).
				body(body)
		.when().post(url).then().extract().response();
		return postrequest;
	}
	
	

	public static Response execute_GETRequest1(String url, Map<String, String> queryParams) {
	    Response getRequest = RestAssured.given()
	        .headers("content-type", "application/json").
	        
	        queryParams(queryParams) // Add query parameters
	        .when()
	        .get(url)
	        .then()
	        .extract()
	        .response();
	    return getRequest;
	}
	
	public static Response execute_GETRequest(String url,String cookievalue) {
		Response postrequest = RestAssured.given().headers("content-type","application/json").
				headers("cookieskey",cookievalue)
		.when().get(url).then().extract().response();
		
		return postrequest;
	}

	public static String readJsonFile(String filepath) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
}
