package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ScheduleElement {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("scheduled_start")
    private String scheduledStart;
    
    @JsonProperty("scheduled_end")
    private String scheduledEnd;
    
    @JsonProperty("duration")
    private Duration duration;
    
    @JsonProperty("transmission_start")
    private String transmissionStart;
    
    @JsonProperty("transmission_end")
    private String transmissionEnd;
    
    @JsonProperty("blanked")
    private Boolean blanked;
    
    @JsonProperty("repeat")
    private Boolean repeat;
    
    @JsonProperty("episode")
    private Episode episode;
    
    @JsonProperty("episode_id")
    private String episodeId;
    
    @JsonProperty("version_id")
    private String versionId;
    
    @JsonProperty("service_id")
    private String serviceId;
    
    @JsonProperty("channel_title")
    private String channelTitle;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("events")
    private List<Event> events;
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getScheduledStart() {
        return scheduledStart;
    }
    
    public void setScheduledStart(String scheduledStart) {
        this.scheduledStart = scheduledStart;
    }
    
    public String getScheduledEnd() {
        return scheduledEnd;
    }
    
    public void setScheduledEnd(String scheduledEnd) {
        this.scheduledEnd = scheduledEnd;
    }
    
    public Duration getDuration() {
        return duration;
    }
    
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    
    public String getTransmissionStart() {
        return transmissionStart;
    }
    
    public void setTransmissionStart(String transmissionStart) {
        this.transmissionStart = transmissionStart;
    }
    
    public String getTransmissionEnd() {
        return transmissionEnd;
    }
    
    public void setTransmissionEnd(String transmissionEnd) {
        this.transmissionEnd = transmissionEnd;
    }
    
    public Boolean getBlanked() {
        return blanked;
    }
    
    public void setBlanked(Boolean blanked) {
        this.blanked = blanked;
    }
    
    public Boolean getRepeat() {
        return repeat;
    }
    
    public void setRepeat(Boolean repeat) {
        this.repeat = repeat;
    }
    
    public Episode getEpisode() {
        return episode;
    }
    
    public void setEpisode(Episode episode) {
        this.episode = episode;
    }
    
    public String getEpisodeId() {
        return episodeId;
    }
    
    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }
    
    public String getVersionId() {
        return versionId;
    }
    
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }
    
    public String getServiceId() {
        return serviceId;
    }
    
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    
    public String getChannelTitle() {
        return channelTitle;
    }
    
    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
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
}