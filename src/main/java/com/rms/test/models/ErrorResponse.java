package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {
    @JsonProperty("version")
    private String version;
    
    @JsonProperty("schema")
    private String schema;
    
    @JsonProperty("error")
    private ErrorDetails error;
    
    // Getters and setters
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getSchema() {
        return schema;
    }
    
    public void setSchema(String schema) {
        this.schema = schema;
    }
    
    public ErrorDetails getError() {
        return error;
    }
    
    public void setError(ErrorDetails error) {
        this.error = error;
    }
    
    // Inner class for the error object
    public static class ErrorDetails {
        @JsonProperty("details")
        private String details;
        
        @JsonProperty("http_response_code")
        private Integer httpResponseCode;
        
        // Getters and setters
        public String getDetails() {
            return details;
        }
        
        public void setDetails(String details) {
            this.details = details;
        }
        
        public Integer getHttpResponseCode() {
            return httpResponseCode;
        }
        
        public void setHttpResponseCode(Integer httpResponseCode) {
            this.httpResponseCode = httpResponseCode;
        }
    }
}