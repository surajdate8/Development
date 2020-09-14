package com.src.excels;

import org.testng.annotations.Test;
import io.restassured.response.*;
import io.restassured.RestAssured;

public class Methods {

	@Test
	public void TC_get()
	{
		Response res=RestAssured.get("https://reqres.in/api/users?page=2&id=7");
		System.out.println(res.asString());
		
		
	}

}
