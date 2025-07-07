package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Synopses {
    @JsonProperty("small")
    private String small;
    
    @JsonProperty("medium")
    private String medium;
    
    @JsonProperty("large")
    private String large;
    
    @JsonProperty("editorial")
    private String editorial;
    
    // Getters and setters
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
    
    public String getLarge() {
        return large;
    }
    
    public void setLarge(String large) {
        this.large = large;
    }
    
    public String getEditorial() {
        return editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}