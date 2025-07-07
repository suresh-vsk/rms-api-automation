package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Availability {
    @JsonProperty("end")
    private String end;
    
    @JsonProperty("start")
    private String start;
    
    @JsonProperty("remaining")
    private Remaining remaining;
    
    // Getters and setters
    public String getEnd() {
        return end;
    }
    
    public void setEnd(String end) {
        this.end = end;
    }
    
    public String getStart() {
        return start;
    }
    
    public void setStart(String start) {
        this.start = start;
    }
    
    public Remaining getRemaining() {
        return remaining;
    }
    
    public void setRemaining(Remaining remaining) {
        this.remaining = remaining;
    }
}