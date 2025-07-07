package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Schedule {
    @JsonProperty("channel")
    private Channel channel;
    
    @JsonProperty("elements")
    private List<ScheduleElement> elements;
    
    public Channel getChannel() {
        return channel;
    }
    
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    
    public List<ScheduleElement> getElements() {
        return elements;
    }
    
    public void setElements(List<ScheduleElement> elements) {
        this.elements = elements;
    }
}