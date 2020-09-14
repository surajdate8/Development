package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.*;

public class AddPlaceAPI extends Utils{


	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	static String placeId;

	TestDataBuilder data=new TestDataBuilder();

	@Given("Add Place Payload  with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException 
	{	
		System.out.println("Started");
		res=given().spec(Utils.requestSpecification())
				.body(data.addPlacePayload(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		resspec =new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();

		APIResoures URI=APIResoures.valueOf(resource);

		if(method.equalsIgnoreCase("POST")) 
			response=res.when().post(URI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response=res.when().get(URI.getResource());
		else if(method.equalsIgnoreCase("DELETE"))
			response=res.when().delete(URI.getResource());
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		
		assertEquals(getJsonPath(response, keyValue),expectedValue);
	}

	@Then("{string} in response body iss {string}")
	public void in_response_body_iss(String keyValue, String expectedValue) {
		assertEquals(getJsonPath(response, keyValue),expectedValue);
		System.out.println("Done");
	}
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resourse) throws IOException {
		placeId=getJsonPath(response, "place_id");
		res=given().spec(Utils.requestSpecification()).queryParam("place_id",placeId);
		user_calls_with_http_request(resourse, "GET");		
		String actualName=getJsonPath(response, "name");
		assertEquals(expectedName,actualName);
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {

		res=given().spec(Utils.requestSpecification())
		.body(data.deletePlacePayload(placeId));
		
	}




}
