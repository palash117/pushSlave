package com.example.pushSlave.pushSlave.processor.processorImpl;

import com.example.pushSlave.pushSlave.event.impl.BasicEvent;
import com.example.pushSlave.pushSlave.event.impl.VolumeEvent;
import com.example.pushSlave.pushSlave.operator.SystemOperator;
import com.example.pushSlave.pushSlave.operator.UbuntuSystemOperator;
import org.springframework.stereotype.Component;

@Component
public class EventProessor {

    SystemOperator systemOperator = getSystemOperatorByOs();

    private SystemOperator getSystemOperatorByOs() {
        switch ( System.getProperty("os.name").toUpperCase()){
           case UbuntuSystemOperator.OS_NAME :
            return  new UbuntuSystemOperator();
        }
        return  null;
    }

    public  String openLink(BasicEvent basicEvent){
        return  systemOperator.openLink(basicEvent);
    };

    public String increaseVolume(VolumeEvent volumeEvent){
        return systemOperator.increaseVolume(volumeEvent);
    };

    public  String decreaseVolume(VolumeEvent volumeEvent){
        return systemOperator.decreaseVolume(volumeEvent);
    };


}
