package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.*;

public class AddPlaceAPI {

	RequestSpecification req;
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	JsonPath js;

	@Given("Add Place Payload")
	public void add_place_payload() {
		System.out.println("Started");

		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("Marathi");
		p.setPhone_number("8888888888");
		p.setWebsite("www.google.com");
		p.setName("Rahul");

		ArrayList<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);

		Location l=new Location();
		l.setLat(-34.00);
		l.setLng(-38.00);
		p.setLocation(l);

		req=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();

		resspec= new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		res=given().log().all().spec(req).body(p);


	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
		response=(Response) res
				.when().post("/maps/api/place/add/json")
				.then().log().all().spec (resspec).extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
		js=new JsonPath(response.asString());
		assertEquals(js.get(string), string2);
	}

	@Then("{string} in response body iss {string}")
	public void in_response_body_iss(String string, String string2) {
		assertEquals(js.get(string), string2);
		System.out.println("Done");
	}


}
