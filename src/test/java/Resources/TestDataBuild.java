package Resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.DeletePlace;
import POJO.Location;

public class TestDataBuild {

	public AddPlace AddPlacePayload(String Name, String Language , String Address)
	{
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(Address);
		p.setLanguage(Language);
		p.setName(Name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		
		List<String> type = new ArrayList <String> ();
		type.add("Test1");
		type.add("Test2");
		
		p.setTypes(type);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		return p;
	}
	
	public DeletePlace DeletePlaceAPIPayload(String Place_id)
	{
		DeletePlace D = new DeletePlace();
		D.setPlace_id(Place_id);
		return D;
	}
	
}

