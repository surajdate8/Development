package resources;

import java.util.ArrayList;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuilder {
	
	public AddPlace addPlacePayload() {
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

		return p;
	}

}
