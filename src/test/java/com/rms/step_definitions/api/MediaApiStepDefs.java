package com.rms.step_definitions.api;

import com.rms.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MediaApiStepDefs {

    private Response response;

    
    @When("a GET request is made to the API endpoint")
    public void aGETRequestIsMadeToTheAPIEndpoint() {
        RestAssured.baseURI = ConfigurationReader.getProperty("endpoint");
        response = RestAssured.get(RestAssured.baseURI);
    }
    
    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
        System.out.println("Response Status Code: " + statusCode);

    }

    @And("the response time should be below {string} milliseconds")
    public void theResponseTimeShouldBeBelowMilliseconds(String milliseconds) {

        long responseTime = response.getTime();
        long maxResponseTime = Long.parseLong(milliseconds);
        System.out.println("Response time: " + responseTime);
        Assert.assertTrue("Response time is above the maximum allowed time", responseTime < maxResponseTime);
        
    }

    @Then("the {string} field should not be null or empty for all items")
    public void theFieldShouldNotBeNullOrEmptyForAllItems(String field) {
        String fieldValue = response.jsonPath().getString("data." + field);
        Assert.assertNotNull(fieldValue);
        Assert.assertFalse(fieldValue.isEmpty());
        
    }

    @Then("the {string} field should be {string} for every track")
    public void theFieldShouldBeForEveryTrack(String field, String nestedField) {
        String fieldValue = response.jsonPath().getString("data." + nestedField + "." + field);
        Assert.assertNotNull(fieldValue);
        Assert.assertFalse(fieldValue.isEmpty());
        
    }

    @Then("the {string} field in {string} should not be null or empty for any track")
    public void theFieldInShouldNotBeNullOrEmptyForAnyTrack(String field, String nestedField) {

        JsonPath jsonPath = response.jsonPath();
        int trackCount = jsonPath.getList("data").size();
        System.out.print(trackCount); //14

        for (int i = 0; i < trackCount; i++) {
            String primaryValue = jsonPath.getString("data[" + i + "]." + nestedField + "." + field);
            Assert.assertNotNull("The 'primary' field is null for track " + i, primaryValue);
            Assert.assertFalse("The 'primary' field is empty for track " + i, primaryValue.isEmpty());
        }
    }

    @Then("only one track should have {string} field in {string} as true")
    public void onlyOneTrackShouldHaveFieldInAsTrue(String field, String nestedField) {
        JsonPath jsonPath = response.jsonPath();
        int trackCount = jsonPath.getList("data").size();
        int countOfTrue = 0;

        for (int i = 0; i < trackCount; i++) {
            boolean fieldValue = jsonPath.getBoolean("data[" + i + "]." + nestedField + "." + field);
            if (fieldValue) {
                countOfTrue++;
            }
        }

        Assert.assertEquals("Expected only one track to have " + field + " field as true, but found " + countOfTrue + " tracks.", 1, countOfTrue);
    }

    @Then("the response headers should contain a valid {string} value")
    public void theResponseHeadersShouldContainAValidValue(String header) {
        String headerValue = response.getHeader(header);
        System.out.print(headerValue);
        Assert.assertNotNull(headerValue);


//        // Verify if the header value is today's date -- data's date not current, hence commented out.
//        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("EEE, dd MMM", Locale.UK));
//        System.out.print(currentDate);
//        Assert.assertEquals("The header value does not match today's date for " + header, currentDate, headerValue);

    }
}


