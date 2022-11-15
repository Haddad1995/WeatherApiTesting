package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetPostSteps {

    private static ResponseOptions<Response> response;

    @Given("^I perform Get Operation for \"([^\"]*)\"$")
    public void iPerformGetOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("^I should see the status code as \"([^\"]*)\"$")
    public void iShouldSeeTheStatusCodeAs(String statusCode) throws Throwable {
        assertThat(response.getStatusCode(), equalTo(200));

    }

}
