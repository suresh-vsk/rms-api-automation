package com.rms.test.steps;

import io.restassured.response.Response;
import com.rms.test.models.ScheduleResponse;

public class SharedContext {
    private static Response response;
    private static ScheduleResponse scheduleResponse;
    
    public static void setResponse(Response response) {
        SharedContext.response = response;
    }
    
    public static Response getResponse() {
        return response;
    }
    
    public static void setScheduleResponse(ScheduleResponse scheduleResponse) {
        SharedContext.scheduleResponse = scheduleResponse;
    }
    
    public static ScheduleResponse getScheduleResponse() {
        return scheduleResponse;
    }
    
    public static void clear() {
        response = null;
        scheduleResponse = null;
    }
}