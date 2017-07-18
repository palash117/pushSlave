package com.example.pushSlave.pushSlave.service.impl;

import com.example.pushSlave.pushSlave.event.impl.BasicEvent;
import com.example.pushSlave.pushSlave.event.type.EventType;
import com.example.pushSlave.pushSlave.pushConstants.PushConstants;
import com.example.pushSlave.pushSlave.service.Servicable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by palash on 11/7/17.
 */
@Service
public class BasicService implements Servicable {


    @Override
    public String processEvent(BasicEvent event) {
        String response = PushConstants.ERROR;
        if(event.getType().equals(EventType.YOUTUBE)&&checkLinkForYoutube(event.getLink())){

            try {
                String os = System.getProperty("os.name");
                if(os.toUpperCase().contains("WINDOWS")){
                    Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c"," start chrome"+event.getLink()});
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

    private boolean checkLinkForYoutube(String link) {

        return true;

    }
}
