package com.example.pushSlave.pushSlave.operator;

import com.example.pushSlave.pushSlave.event.impl.BasicEvent;
import com.example.pushSlave.pushSlave.event.impl.VolumeEvent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;


 public abstract class SystemOperator {

    public abstract  String openLink(BasicEvent basicEvent);

    public abstract String increaseVolume(VolumeEvent volumeEvent);

    public abstract String decreaseVolume(VolumeEvent volumeEvent);


}

