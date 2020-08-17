package com.rest.basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;
import org.hamcrest.Matcher.*;

public class RestBasic {

	public static void main(String[] args) {
		
		
		//post API
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res= given().log().all()
				.queryParam("key", "qaclick123")
				.header("Content-Type","application/json")
				.body(AddPlace.Place())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response();
		
		System.out.println(res.asString());
		JsonPath js=new JsonPath(res.asString());
		String place=js.get("place_id");
		System.out.println(place);
		
		//put API
		
		Response resput=(Response)given().log().all()
		.queryParam("key", "qaclick12")
		.header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+place+"\",\r\n" + 
				"\"address\":\"29, side layout, cohen 09\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}")
		.when().put("map/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).extract().response();
	}

}
