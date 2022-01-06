package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;

public class TestDataBuild {

	public AddPlace addplacePayload(String name) {
		AddPlace p = new AddPlace();
		p.setAccuracy(100);
		p.setAddress("sandhiya");
		p.setLanguage("sdfsdf");
		p.setName(name);
		p.setPhone_number("lkjldfs");
		p.setWebsite("sfsdf");
		List<String> myList = new ArrayList<String>();
		myList.add("sdfsd");
		myList.add("sdfsdfsdF");
		p.setTypes(myList);

		Location loc = new Location();
		loc.setLatitude(23.423432);
		loc.setLongitude(24.33442);
		p.setLocation(loc);
		return p;
	}
}
