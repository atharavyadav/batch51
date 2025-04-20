package API_TestCases;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostReq {

	public static void main(String[] args) {
		
		Response postrequest = RestAssured.given().headers("content-type","application/json").body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"1 TB\"\r\n"
				+ "   }\r\n"
				+ "}")
		.when().post("https://api.restful-api.dev/objects").then().extract().response();

		System.out.println(postrequest.statusCode());
		System.out.println(postrequest.getBody().asString());
	}

}
