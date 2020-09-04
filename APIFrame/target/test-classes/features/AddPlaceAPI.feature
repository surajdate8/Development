Feature: REST

	Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
	Given Add Place Payload  with "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body iss "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
	|name	|language	|address	|
	|AAhouse|English	|WTC		|
	|BBHouse|French		|EDC		|