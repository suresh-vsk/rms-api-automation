package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Channel {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("has_schedule")
    private Boolean hasSchedule;
    
    @JsonProperty("master_brand_id")
    private String masterBrandId;
    
    @JsonProperty("master_brand_title")
    private String masterBrandTitle;
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Boolean getHasSchedule() {
        return hasSchedule;
    }
    
    public void setHasSchedule(Boolean hasSchedule) {
        this.hasSchedule = hasSchedule;
    }
    
    public String getMasterBrandId() {
        return masterBrandId;
    }
    
    public void setMasterBrandId(String masterBrandId) {
        this.masterBrandId = masterBrandId;
    }
    
    public String getMasterBrandTitle() {
        return masterBrandTitle;
    }
    
    public void setMasterBrandTitle(String masterBrandTitle) {
        this.masterBrandTitle = masterBrandTitle;
    }
}