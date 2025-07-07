package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Titles {
    @JsonProperty("large")
    private String large;
    
    @JsonProperty("small")
    private String small;
    
    @JsonProperty("medium")
    private String medium;
    
    // Getters and setters
    public String getLarge() {
        return large;
    }
    
    public void setLarge(String large) {
        this.large = large;
    }
    
    public String getSmall() {
        return small;
    }
    
    public void setSmall(String small) {
        this.small = small;
    }
    
    public String getMedium() {
        return medium;
    }
    
    public void setMedium(String medium) {
        this.medium = medium;
    }
}