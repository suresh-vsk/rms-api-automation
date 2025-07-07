package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Remaining {
    @JsonProperty("text")
    private String text;
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}