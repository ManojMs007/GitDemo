Feature: Validating Place API's

@AddPlace @Sanity @regression
Scenario Outline: Verify Add Place API is working and giving 200OK Response
Given Add place payload with "<Name>" , "<Language>" and "<Address>"
When User Calls "AddPlaceAPI" with "Post" Http Request
Then API call is success with status code as 200
And "status" in Response JSON is "OK"
And "scope" in Response JSON is "APP"
And Verify place_Id Created Maps to "<Name>" using "GetPlaceAPI" for "place_id"
Examples:
	|Name	|Language	| Address|
	|Manoj	|en-Us 		|Stanta Cruze|
	|Kiran	|en-fr		|Manta Cruze|
	
	@DeletePlace @regression
Scenario: Verify if delete functionality is working as Expected

Given DeletePlace API Payload with "place_id"
When User Calls "DeletePlaceAPI" with "Post" Http Request
Then API call is success with status code as 200
And "status" in Response JSON is "OK"
	