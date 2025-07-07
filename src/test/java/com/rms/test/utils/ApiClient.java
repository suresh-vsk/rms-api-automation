// filepath: src/test/java/com/rms/test/utils/ApiClient.java
package com.rms.test.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.rms.test.models.ErrorResponse;
import com.rms.test.models.ScheduleResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    
    private static final String BASE_URL = "https://testapi.io/api/RMSTest";
    private static final String ENDPOINT = "/ibltest";
    private final ObjectMapper objectMapper;
    
    public ApiClient() {
        RestAssured.baseURI = BASE_URL;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    public Response getScheduleData() {
        RequestSpecification request = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");
        
        return request.get(ENDPOINT);
    }
    
    public Response getScheduleDataWithPath(String additionalPath) {
        RequestSpecification request = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json");
        
        return request.get(ENDPOINT + additionalPath);
    }
    
    public ScheduleResponse getScheduleResponseModel() {
        Response response = getScheduleData();
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to get successful response. Status code: " + response.getStatusCode());
        }
        
        try {
            return objectMapper.readValue(response.asString(), ScheduleResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse schedule response: " + e.getMessage(), e);
        }
    }
    
    public ScheduleResponse parseScheduleResponse(Response response) {
        try {
            return objectMapper.readValue(response.asString(), ScheduleResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse schedule response: " + e.getMessage(), e);
        }
    }
    
    public ErrorResponse getErrorResponseModel(Response response) {
        try {
            return objectMapper.readValue(response.asString(), ErrorResponse.class);
        } catch (Exception e) {
            // If parsing fails, create a basic error response
            return createErrorResponseFromRawResponse(response);
        }
    }
    
    private ErrorResponse createErrorResponseFromRawResponse(Response response) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setVersion("1.0");
        errorResponse.setSchema("/v1/schema.json");
        
        // Create the error details
        ErrorResponse.ErrorDetails errorDetails = new ErrorResponse.ErrorDetails();
        errorDetails.setDetails("Error response received: " + response.asString());
        errorDetails.setHttpResponseCode(response.getStatusCode());
        
        errorResponse.setError(errorDetails);
        
        return errorResponse;
    }
}