package com.rms.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleResponse {
    @JsonProperty("schedule")
    private Schedule schedule;
    
    public Schedule getSchedule() {
        return schedule;
    }
    
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}