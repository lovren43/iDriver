package com.software.software.ride;


import java.time.LocalDate;
import java.time.LocalTime;

public abstract class event {
    
    public String eventName;
    public LocalTime eventTime;
    LocalDate eventDate;
    public String eventCaptain;
    String eventUser;
    public event(Ride ride){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        this.setEventCaptain(ride.getDriver().getPersonInfo().getUserName());
        this.setEventUser(ride.getUser().getPersonInfo().getUserName());
        this.setEventTime(localTime);
        this.setEventDate(localDate);
    }
    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventCaptain() {
        return eventCaptain;
    }

    public void setEventCaptain(String eventCaptain) {
        this.eventCaptain = eventCaptain;
    }

    public String getEventUser() {
        return eventUser;
    }

    public void setEventUser(String eventUser) {
        this.eventUser = eventUser;
    }
}

