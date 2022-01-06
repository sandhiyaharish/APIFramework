Feature: Validating AddPlace API

Scenario Outline:Verify if Place is being successfully added using AddPlaceAPI
Given Add Place Payload "<name>"
When user calls "AddPlaceAPIrt" with Post http request
Then the API call is success with status code 200
And "status" in response body is "ok"
And "scope" in response body is "App"


Examples:
|name|language|
|Sandhiya|English|
|Harish|Hindi|