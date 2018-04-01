package com.example.pushSlave.pushSlave.event.impl;

import com.example.pushSlave.pushSlave.event.Eventable;
import com.example.pushSlave.pushSlave.event.type.EventType;

/**
 * Created by palash on 12/7/17.
 */
public class BasicEvent implements Eventable {

    public String destination;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public EventType type;

    public String link;


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
