package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("offset")
    private Integer offset;
    
    @JsonProperty("system")
    private String system;
    
    @JsonProperty("time")
    private String time;
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getOffset() {
        return offset;
    }
    
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    
    public String getSystem() {
        return system;
    }
    
    public void setSystem(String system) {
        this.system = system;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
}