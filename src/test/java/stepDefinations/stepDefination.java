package stepDefinations;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.AddPlaceResponse;
import POJO.Location;
import Resources.GetAPIUrl;
import Resources.Reused;
import Resources.TestDataBuild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.netty.handler.codec.http.HttpRequest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination {
	RequestSpecification res;
	ResponseSpecification Resp;
	Response Respon;
	AddPlaceResponse P;
	JsonPath Js;
	TestDataBuild TDB = new TestDataBuild();
	Reused RE = new Reused();
	static String Place_id;
	@Given("Add place payload with {string} , {string} and {string}")
	public void add_place_payload_with_and(String Name, String Language, String Address) throws IOException {
	    
	
	
	
	res = given().spec(RE.requestBuild()).body(TDB.AddPlacePayload(Name, Language, Address));
	

	System.out.println("GitStuff /gitx Change for git test");

	System.out.println("Git Demo Change - github");

	
	//Changes for deveop branch
	
	/*
	 * System.out.println("Develop branch changes 1: ");
	 * System.out.println("Develop branch changes 1: ");
	 * System.out.println("Develop branch changes 1: ");
	 * System.out.println("Develop branch changes 1: ");
	 * 
	 * System.out.println("Comit");
	 * 
	 * System.out.println("Develop 2 changes");
	 */
	}
	@When("User Calls {string} with {string} Http Request")
	public void user_calls_with_http_request(String Resource, String httpreq) {
	    // Write code here that turns the phrase above into concrete actions
		GetAPIUrl	APIResource = GetAPIUrl.valueOf(Resource);
		if(httpreq.equalsIgnoreCase("Post"))
			Respon = res.when().post(APIResource.GetResource());
		else if(httpreq.equalsIgnoreCase("get"))
			Respon = res.when().get(APIResource.GetResource());
	}
	@Then("API call is success with status code as {int}")
	public void api_call_is_success_with_status_code_as(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		String Res = Respon.asString();
		Js = new JsonPath(Res);
		System.out.println("Response String: "+Respon.asString());
		Resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		assertEquals(Respon.statusCode(), int1);
	}
	@Then("{string} in Response JSON is {string}")
	public void in_response_json_is(String key, String Value) {
	    // Write code here that turns the phrase above into concrete actions

assertEquals(RE.getjsonpath(Respon, key), Value);
	}
	@Then("Verify place_Id Created Maps to {string} using {string} for {string}")
	public void verify_place_id_created_maps_to_using_for(String Name, String Resource, String place_id) throws IOException  {
	    // Write code here that turns the phrase above into concrete actions
		Place_id = RE.getjsonpath(Respon, place_id);
		
		res = given().spec(RE.requestBuild()).queryParam(place_id, Place_id);
		user_calls_with_http_request( Resource,  "Get");
		assertEquals(RE.getjsonpath(Respon, "name"), Name);
	}
	
	@Given("DeletePlace API Payload with {string}")
	public void delete_place_api_payload_with(String Placeid) throws IOException {
		Placeid = Place_id;
	    // Write code here that turns the phrase above into concrete actions
		res = given().spec(RE.requestBuild()).body(TDB.DeletePlaceAPIPayload(Placeid));

	}

}
