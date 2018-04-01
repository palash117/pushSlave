package com.example.pushSlave.pushSlave.service.impl;

import com.example.pushSlave.pushSlave.processor.processorImpl.EventProessor;
import com.example.pushSlave.pushSlave.event.impl.BasicEvent;
import com.example.pushSlave.pushSlave.event.impl.VolumeEvent;
import com.example.pushSlave.pushSlave.event.type.EventType;
import com.example.pushSlave.pushSlave.pushConstants.PushConstants;
import com.example.pushSlave.pushSlave.service.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by palash on 11/7/17.
 */
@Service
public class BasicService implements Servicable {

    @Autowired
    EventProessor eventProessor;

    @Override
    public String processEvent(BasicEvent event) {
        String response = PushConstants.ERROR;
        if(event.getType().equals(EventType.YOUTUBE)&&checkLinkForYoutube(event.getLink())){

            try {
                String os = System.getProperty("os.name");
                if(os.toUpperCase().contains("WINDOWS")){
                    Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c"," start chrome "+event.getLink()});
                }
                else {
                    Runtime.getRuntime().exec(new String[]{"google-chrome", event.getLink()});
                }
                response = PushConstants.SUCCESS;
            } catch (IOException e) {
                e.printStackTrace();
                response = PushConstants.ERROR;
            }

        }

        return response;


    }

    @Override
    public String changeVolume(VolumeEvent volumeEvent) {
        return  eventProessor.increaseVolume(
                volumeEvent
        ) ;
    }

    private boolean checkLinkForYoutube(String link) {

        return true;

    }


}
