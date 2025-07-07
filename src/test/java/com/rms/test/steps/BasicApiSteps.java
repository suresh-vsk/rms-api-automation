package com.rms.test.steps;

import com.rms.test.models.ScheduleResponse;
import com.rms.test.utils.ApiClient;
import com.rms.test.utils.ResponseValidator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//import static org.assertj.core.api.Assertions.assertThat;

public class BasicApiSteps {
    
    private ApiClient apiClient;
    private Response response;
    private ResponseValidator validator;
    private ScheduleResponse scheduleResponse;
    
    public BasicApiSteps() {
        this.apiClient = new ApiClient();
        this.validator = new ResponseValidator();
    }
    
    @Given("I make a GET request to the RMS API endpoint")
    public void i_make_a_get_request_to_the_rms_api_endpoint() {
        response = apiClient.getScheduleData();
        
        // Store in shared context for other step classes
        SharedContext.setResponse(response);
        
        // Parse response into a model if successful
        if (response.getStatusCode() == 200) {
            scheduleResponse = apiClient.parseScheduleResponse(response);
            SharedContext.setScheduleResponse(scheduleResponse);
        }
    }
    
    @Given("I make a GET request to the RMS API endpoint with invalid path {string}")
    public void i_make_a_get_request_to_the_rms_api_endpoint_with_invalid_path(String invalidPath) {
        response = apiClient.getScheduleDataWithPath(invalidPath);
        
        // Store in shared context for other step classes
        SharedContext.setResponse(response);
        // Don't parse into a model for error responses
    }
    
    @When("I receive the response")
    public void i_receive_the_response() {
        // Response is already captured in the Given step
        Assert.assertNotNull("Response should not be null", response);
    }
    
    @Then("the HTTP status code should be {int}")
    public void the_http_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals("Expected status code: " + expectedStatusCode + ", but got: " + response.getStatusCode(),
                expectedStatusCode, response.getStatusCode());
    }
    
    @Then("the response time should be below {int} milliseconds")
    public void the_response_time_should_be_below_milliseconds(int maxResponseTime) {
        long responseTime = response.getTime();
        Assert.assertTrue("Response time should be below " + maxResponseTime + "ms, but was: " + responseTime + "ms",
                responseTime < maxResponseTime);
    }
    
    @Then("the error object should have properties {string} and {string}")
    public void the_error_object_should_have_properties_and(String property1, String property2) {
        validator.validateErrorProperties(response, property1, property2);
    }
    
    @Then("the response headers should contain {string} field")
    public void the_response_headers_should_contain_field(String headerName) {
        String headerValue = response.getHeader(headerName);
        Assert.assertNotNull("Header '" + headerName + "' should be present", headerValue);
        Assert.assertFalse("Header '" + headerName + "' should not be empty", headerValue.isEmpty());
    }
    
    @Then("the {string} header should have a valid date format")
    public void the_header_should_have_valid_date_format(String headerName) {
        String dateHeader = response.getHeader(headerName);
        Assert.assertNotNull("Date header should not be null", dateHeader);

        // simply verify the date pattern
        // assertThat(dateHeader).matches("^[A-Za-z]{3}, \\d{2} [A-Za-z]{3} \\d{4} \\d{2}:\\d{2}:\\d{2} GMT$");

        // or Validate date format with a set of patterns (standard HTTP date format)
        SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH),
            new SimpleDateFormat("EEEE, dd-MMM-yy HH:mm:ss zzz", Locale.ENGLISH),
            new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.ENGLISH)
        };
        
        boolean isValidDate = false;
        for (SimpleDateFormat format : dateFormats) {
            try {
                Date parsedDate = format.parse(dateHeader);
                isValidDate = true;
                break;
            } catch (ParseException e) {
                // Try next format
            }
        }
        
        Assert.assertTrue("Date header '" + dateHeader + "' is not in a valid format", isValidDate);
    }
    
    // Additional step to validate response structure using model classes
    @Then("the response should have valid schedule structure")
    public void the_response_should_have_valid_schedule_structure() {
        Assert.assertNotNull("Schedule response should not be null", scheduleResponse);
        Assert.assertNotNull("Schedule should not be null", scheduleResponse.getSchedule());
        Assert.assertNotNull("Channel should not be null", scheduleResponse.getSchedule().getChannel());
        Assert.assertNotNull("Elements should not be null", scheduleResponse.getSchedule().getElements());
        Assert.assertFalse("Elements should not be empty", scheduleResponse.getSchedule().getElements().isEmpty());
    }
    
    // Additional step to validate channel information using model classes
    @Then("the channel should have valid information")
    public void the_channel_should_have_valid_information() {
        Assert.assertNotNull("Schedule response should not be null", scheduleResponse);
        var channel = scheduleResponse.getSchedule().getChannel();
        
        Assert.assertNotNull("Channel ID should not be null", channel.getId());
        Assert.assertFalse("Channel ID should not be empty", channel.getId().trim().isEmpty());
        
        Assert.assertNotNull("Channel title should not be null", channel.getTitle());
        Assert.assertFalse("Channel title should not be empty", channel.getTitle().trim().isEmpty());
        
        Assert.assertNotNull("Channel type should not be null", channel.getType());
        Assert.assertEquals("Channel type should be 'channel'", "channel", channel.getType());
    }
}