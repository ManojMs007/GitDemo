package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeDeletePlace() throws IOException
	{
		stepDefination sd = new stepDefination();
		if(sd.Place_id == null)
		{
		sd.add_place_payload_with_and("Shetty", "en-fr", "India");
		sd.user_calls_with_http_request("AddPlaceAPI", "Post");
		sd.verify_place_id_created_maps_to_using_for("Shetty", "GetPlaceAPI", "place_id");
		}
	}
}
