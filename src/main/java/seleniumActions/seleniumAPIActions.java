package seleniumActions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reusableData.resusebaleData;

public class seleniumAPIActions {
	
	
	public static Response execute_PostRequest(String body , String url) {
		Response postrequest = RestAssured.given().headers("content-type","application/json").body(body)
		.when().post(url).then().extract().response();
		return postrequest;
	}

	public static String readJsonFile(String filepath) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
}
