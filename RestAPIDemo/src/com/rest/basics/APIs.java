package com.rest.basics;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;
import org.hamcrest.Matcher.*;
import org.testng.annotations.Test;

public class APIs {
	@Test
	public void addbook() {
		RestAssured.baseURI="http://216.10.245.166";
	
		String res=given().header("Content-Type", "application/json").body(Payload.Addbook()).
				when().post("/Library/Addbook.php").
				then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=Reusable_Methods.jsMethod(res);
		System.out.println(res);
		System.out.println(js.getString("ID"));
	}

}
