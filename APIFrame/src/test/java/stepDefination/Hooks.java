package stepDefination;

import java.io.IOException;

import io.cucumber.java.Before;
public class Hooks {
	@Before("@DeletePlace")
	public void before() throws IOException {
		AddPlaceAPI p=new AddPlaceAPI();

		if(AddPlaceAPI.placeId==null) {
			p.add_place_payload_with("Suraj", "Marathi", "Akola");
			p.user_calls_with_http_request("addPlaceAPI","POST");
			p.verify_place_id_created_maps_to_using("Suraj","getPlaceAPI");
		}
	}
}
