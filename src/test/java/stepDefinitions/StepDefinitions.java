package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends Utils{
	
	ResponseSpecification resspec;
	RequestSpecification reqSpec;
	Response response;
	TestDataBuild data  = new TestDataBuild();
	
	
	@Given("Add Place Payload {string}")
	public void add_place_payload(String name) throws IOException {
		
	    reqSpec = given().spec(requestSpecification()).body(data.addplacePayload(name));
	}
	
	@When("user calls {string} with Post http request")
	public void user_calls_with_post_http_request(String name) {
	    response = reqSpec.when().post("/maps/api/place/add/json").then().spec(resspec).extract().response();
	}
	
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(int status) {
		   assertEquals(response.statusCode(),200 );
	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedString) {
	    String responseString = response.asString();
	    JsonPath js = new JsonPath(responseString);
	   // assertEquals(js.get(keyValue).toString(),ExpectedString );
	} 


}
