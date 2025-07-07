package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Duration {
    @JsonProperty("value")
    private String value;
    
    @JsonProperty("text")
    private String text;
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}