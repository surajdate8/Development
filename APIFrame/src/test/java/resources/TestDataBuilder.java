package resources;

import java.util.ArrayList;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuilder {
	
	public AddPlace addPlacePayload(String name,String language,String address) {
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("8888888888");
		p.setWebsite("www.google.com");
		p.setName(name);

		ArrayList<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);

		Location l=new Location();
		l.setLat(-34.00);
		l.setLng(-38.00);
		p.setLocation(l);

		return p;
	}
	
	public String deletePlacePayload(String placeId) {
		return  "{  \"place_id\": \""+placeId+"\" }";
	}

}
