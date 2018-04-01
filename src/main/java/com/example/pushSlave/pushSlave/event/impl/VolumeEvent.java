package com.example.pushSlave.pushSlave.event.impl;

import com.example.pushSlave.pushSlave.event.Eventable;

public class VolumeEvent extends BasicEvent {

    int volumePercentage;

    public VolumeEvent(){
        super();
    };

    public VolumeEvent(int volumePercentage){
        super();
        this.volumePercentage = volumePercentage;
    }


    public int getVolumePercentage() {
        return volumePercentage;
    }

    public void setVolumePercentage(int volumePercentage) {
        this.volumePercentage = volumePercentage;
    }

    @Override
    public String toString() {
        return "VolumeEvent{" +
                "volumePercentage=" + volumePercentage +
                '}';
    }
}

