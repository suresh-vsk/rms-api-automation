package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Labels {
    @JsonProperty("category")
    private String category;
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
}