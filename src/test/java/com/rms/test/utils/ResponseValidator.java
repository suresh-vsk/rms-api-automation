package com.rms.test.utils;

import com.rms.test.models.ErrorResponse;
import com.rms.test.models.ScheduleElement;
import com.rms.test.models.ScheduleResponse;
import io.restassured.response.Response;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ResponseValidator {
    
    private final ApiClient apiClient;
    
    public ResponseValidator() {
        this.apiClient = new ApiClient();
    }
    
    public void validateAllElementsHaveNonEmptyField(Response response, String fieldName) {
        ScheduleResponse scheduleResponse = apiClient.parseScheduleResponse(response);
        List<ScheduleElement> elements = scheduleResponse.getSchedule().getElements();
        
        Assert.assertFalse("Schedule elements should not be empty", elements.isEmpty());
        
        for (ScheduleElement element : elements) {
            String id = element.getId();
            Assert.assertNotNull("Element ID should not be null", id);
            Assert.assertFalse("Element ID should not be empty", id.trim().isEmpty());
        }
    }
    
    public void validateAllEpisodesHaveFieldValue(Response response, String fieldName, String expectedValue) {
        ScheduleResponse scheduleResponse = apiClient.parseScheduleResponse(response);
        List<ScheduleElement> elements = scheduleResponse.getSchedule().getElements();
        
        Assert.assertFalse("Schedule elements should not be empty", elements.isEmpty());
        
        for (ScheduleElement element : elements) {
            String episodeType = element.getEpisode().getType();
            Assert.assertEquals("Episode type should be '" + expectedValue + "' but was: " + episodeType,
                    expectedValue, episodeType);
        }
    }
    
    public void validateAllEpisodesHaveNonEmptyField(Response response, String fieldName) {
        ScheduleResponse scheduleResponse = apiClient.parseScheduleResponse(response);
        List<ScheduleElement> elements = scheduleResponse.getSchedule().getElements();
        
        Assert.assertFalse("Schedule elements should not be empty", elements.isEmpty());
        
        for (ScheduleElement element : elements) {
            String title = element.getEpisode().getTitle();
            Assert.assertNotNull("Episode title should not be null", title);
            Assert.assertFalse("Episode title should not be empty", title.trim().isEmpty());
        }
    }
    
    public void validateOnlyOneEpisodeHasLiveFieldTrue(Response response, String fieldName) {
        ScheduleResponse scheduleResponse = apiClient.parseScheduleResponse(response);
        List<ScheduleElement> elements = scheduleResponse.getSchedule().getElements();
        
        long liveCount = elements.stream()
                .mapToLong(element -> Boolean.TRUE.equals(element.getEpisode().getLive()) ? 1 : 0)
                .sum();
        
        Assert.assertEquals("Expected exactly one episode to have live=true, but found: " + liveCount,
                1, liveCount);
    }
    
    public void validateTransmissionTimeOrdering(Response response, String startField, String endField) {
        ScheduleResponse scheduleResponse = apiClient.parseScheduleResponse(response);
        List<ScheduleElement> elements = scheduleResponse.getSchedule().getElements();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        
        for (int i = 0; i < elements.size(); i++) {
            ScheduleElement element = elements.get(i);
            String transmissionStart = element.getTransmissionStart();
            String transmissionEnd = element.getTransmissionEnd();
            
            LocalDateTime startTime = LocalDateTime.parse(transmissionStart, formatter);
            LocalDateTime endTime = LocalDateTime.parse(transmissionEnd, formatter);
            
            Assert.assertTrue("transmission_start should be before transmission_end for element " + i + 
                    ". Start: " + startTime + ", End: " + endTime,
                    startTime.isBefore(endTime));
        }
    }
    
    public void validateErrorProperties(Response response, String property1, String property2) {
        try {
            ErrorResponse errorResponse = apiClient.getErrorResponseModel(response);
            
            Assert.assertNotNull("Error object should not be null", errorResponse.getError());
            Assert.assertNotNull("Error should have details", errorResponse.getError().getDetails());
            Assert.assertNotNull("Error should have http_response_code", errorResponse.getError().getHttpResponseCode());
            
        } catch (Exception e) {
            Assert.fail("Could not validate error properties: " + e.getMessage());
        }
    }
    
    public void validateScheduleDataStructure(Response response) {
        ScheduleResponse scheduleResponse = apiClient.parseScheduleResponse(response);
        
        // Validate top-level structure
        Assert.assertNotNull("Schedule should not be null", scheduleResponse.getSchedule());
        Assert.assertNotNull("Channel should not be null", scheduleResponse.getSchedule().getChannel());
        Assert.assertNotNull("Elements should not be null", scheduleResponse.getSchedule().getElements());
        
        // Validate channel data
        Assert.assertNotNull("Channel ID should not be null", 
                scheduleResponse.getSchedule().getChannel().getId());
        Assert.assertNotNull("Channel title should not be null", 
                scheduleResponse.getSchedule().getChannel().getTitle());
        
        // Validate elements count
        List<ScheduleElement> elements = scheduleResponse.getSchedule().getElements();
        Assert.assertEquals("Expected 5 schedule elements but found: " + elements.size(),
                5, elements.size());
        
        // Validate each element has required fields
        for (int i = 0; i < elements.size(); i++) {
            ScheduleElement element = elements.get(i);
            Assert.assertNotNull("Element " + i + " ID should not be null", element.getId());
            Assert.assertNotNull("Element " + i + " episode should not be null", element.getEpisode());
            Assert.assertNotNull("Element " + i + " episode title should not be null", 
                    element.getEpisode().getTitle());
        }
    }
}