package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CurrentWeatherSteps {

    private static ResponseOptions<Response> response;

    @Given("^I perform Get Operation for \"([^\"]*)\" with Params$")
    public void iPerformGetOperationForWithParams(String url, DataTable table) throws Throwable {
        var data = table.raw();
        HashMap<String, String> param = new HashMap<>();
        param.put("latitude", data.get(1).get(0));
        param.put("longitude", data.get(1).get(1));
        param.put("current_weather", data.get(1).get(2));
        param.put("timezone", data.get(1).get(3));

        response = RestAssuredExtension.GetOpsWithPathParameter(url,param);
    }

    @Then("^I should see the temperature as \"([^\"]*)\"$")
    public void iShouldSeeTheTemperatureAs(String temperature) throws Throwable {
        String result = response.getBody().jsonPath().get("current_weather.temperature").toString();
        assertThat(result, equalTo(temperature));
    }
}
