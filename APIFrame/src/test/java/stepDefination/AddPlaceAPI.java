package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import javax.rmi.CORBA.Util;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.*;

public class AddPlaceAPI extends Utils{

	
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	JsonPath js;
	
	TestDataBuilder data=new TestDataBuilder();

	@Given("Add Place Payload")
	public void add_place_payload() {
		System.out.println("Started");

	
		

		resspec= new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		res=given().log().all().spec(Utils.requestSpecification()).body(data.addPlacePayload());


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
