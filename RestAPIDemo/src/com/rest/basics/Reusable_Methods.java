package com.rest.basics;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Reusable_Methods {

	public static JsonPath jsMethod(String res) {

		JsonPath js=new JsonPath(res);
		return js;
	}
}
