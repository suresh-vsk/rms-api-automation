package com.rms.test.steps;

import com.rms.test.models.ScheduleResponse;
import com.rms.test.utils.ApiClient;
import com.rms.test.utils.ResponseValidator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

public class ScheduleDataSteps {
    
    private ApiClient apiClient;
    private Response response;
    private ResponseValidator validator;
    private ScheduleResponse scheduleResponse;
    
    public ScheduleDataSteps() {
        this.apiClient = new ApiClient();
        this.validator = new ResponseValidator();
    }
    
    @Given("I receive a successful response")
    public void i_receive_a_successful_response() {
        // Get the response from the shared context
        response = SharedContext.getResponse();
        
        Assert.assertEquals("Expected successful response but got: " + response.getStatusCode(),
                200, response.getStatusCode());
        
        // Ensure we have the parsed model
        if (scheduleResponse == null) {
            scheduleResponse = apiClient.parseScheduleResponse(response);
        }
        
        // Additional validation of response structure using model classes
        validator.validateScheduleDataStructure(response);
    }
    
    @Then("all schedule elements should have non-null and non-empty {string} fields")
    public void all_schedule_elements_should_have_non_null_and_non_empty_fields(String fieldName) {
        if (response == null) {
            response = SharedContext.getResponse();
        }
        validator.validateAllElementsHaveNonEmptyField(response, fieldName);
    }
    
    @Then("all episodes should have {string} field as {string}")
    public void all_episodes_should_have_field_as(String fieldName, String expectedValue) {
        if (response == null) {
            response = SharedContext.getResponse();
        }
        validator.validateAllEpisodesHaveFieldValue(response, fieldName, expectedValue);
    }
    
    @Then("all episodes should have non-null and non-empty {string} fields")
    public void all_episodes_should_have_non_null_and_non_empty_fields(String fieldName) {
        if (response == null) {
            response = SharedContext.getResponse();
        }
        validator.validateAllEpisodesHaveNonEmptyField(response, fieldName);
    }
    
    @Then("only one episode should have {string} field as true")
    public void only_one_episode_should_have_field_as_true(String fieldName) {
        if (response == null) {
            response = SharedContext.getResponse();
        }
        validator.validateOnlyOneEpisodeHasLiveFieldTrue(response, fieldName);
    }
    
    @Then("all schedule items should have {string} before {string}")
    public void all_schedule_items_should_have_before(String startField, String endField) {
        if (response == null) {
            response = SharedContext.getResponse();
        }
        validator.validateTransmissionTimeOrdering(response, startField, endField);
    }
}