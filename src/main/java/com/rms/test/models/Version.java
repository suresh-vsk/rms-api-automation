package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Version {
    @JsonProperty("hd")
    private Boolean hd;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("uhd")
    private Boolean uhd;
    
    @JsonProperty("kind")
    private String kind;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("events")
    private List<Event> events;
    
    @JsonProperty("download")
    private Boolean download;
    
    @JsonProperty("duration")
    private Duration duration;
    
    @JsonProperty("availability")
    private Availability availability;
    
    @JsonProperty("first_broadcast")
    private String firstBroadcast;
    
    @JsonProperty("first_broadcast_date_time")
    private String firstBroadcastDateTime;
    
    // Getters and setters
    public Boolean getHd() {
        return hd;
    }
    
    public void setHd(Boolean hd) {
        this.hd = hd;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Boolean getUhd() {
        return uhd;
    }
    
    public void setUhd(Boolean uhd) {
        this.uhd = uhd;
    }
    
    public String getKind() {
        return kind;
    }
    
    public void setKind(String kind) {
        this.kind = kind;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public List<Event> getEvents() {
        return events;
    }
    
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
    public Boolean getDownload() {
        return download;
    }
    
    public void setDownload(Boolean download) {
        this.download = download;
    }
    
    public Duration getDuration() {
        return duration;
    }
    
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    
    public Availability getAvailability() {
        return availability;
    }
    
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
    
    public String getFirstBroadcast() {
        return firstBroadcast;
    }
    
    public void setFirstBroadcast(String firstBroadcast) {
        this.firstBroadcast = firstBroadcast;
    }
    
    public String getFirstBroadcastDateTime() {
        return firstBroadcastDateTime;
    }
    
    public void setFirstBroadcastDateTime(String firstBroadcastDateTime) {
        this.firstBroadcastDateTime = firstBroadcastDateTime;
    }
}