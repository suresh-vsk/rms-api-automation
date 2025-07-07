package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MasterBrand {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("titles")
    private Titles titles;
    
    @JsonProperty("ident_id")
    private String identId;
    
    @JsonProperty("attribution")
    private String attribution;
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Titles getTitles() {
        return titles;
    }
    
    public void setTitles(Titles titles) {
        this.titles = titles;
    }
    
    public String getIdentId() {
        return identId;
    }
    
    public void setIdentId(String identId) {
        this.identId = identId;
    }
    
    public String getAttribution() {
        return attribution;
    }
    
    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }
}