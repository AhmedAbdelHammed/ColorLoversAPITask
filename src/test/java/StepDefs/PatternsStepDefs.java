package StepDefs;

import EndPoints.PatternsEndPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class PatternsStepDefs {
    PatternsEndPoint patternsEndPoint;
    Response getPatternsResponse;

    @Given("The user is able to access color lovers api")
    public void the_user_is_able_to_access_color_lovers_api() {
    patternsEndPoint = new PatternsEndPoint();
    }

    @When("Make a get request to color lovers api patterns EndPoint")
    public void make_a_get_request_to_color_lovers_api_patterns_EndPoint() {
    getPatternsResponse = patternsEndPoint.getPatterns();
    }

    @Then("It should return success status code {int}")
    public void It_should_return_success_status_code(int statusCode){
    Assert.assertEquals(getPatternsResponse.statusCode(),statusCode, "Status code is invalid");
    }

    @And("All the patterns should have views numbers greater than {int}")
    public void All_the_patterns_should_have_views_numbers_greater_than(int expectedNumber) {
        Assert.assertTrue(patternsEndPoint.verifyNumViewsPatters(getPatternsResponse,expectedNumber),
                "The patterns have one or more item with num views less than " +expectedNumber);
    }
}
