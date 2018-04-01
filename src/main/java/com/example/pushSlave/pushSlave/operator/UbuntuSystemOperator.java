package com.example.pushSlave.pushSlave.operator;

import com.example.pushSlave.pushSlave.event.impl.BasicEvent;
import com.example.pushSlave.pushSlave.event.impl.VolumeEvent;
import com.example.pushSlave.pushSlave.pushConstants.PushConstants;

import java.io.IOException;

public class UbuntuSystemOperator extends  SystemOperator {
    public static final String OS_NAME ="LINUX";
    @Override
    public String openLink(BasicEvent event) {
        String response = PushConstants.ERROR;
            try {
                    Runtime.getRuntime().exec(new String[]{"google-chrome", event.getLink()});
                response = PushConstants.SUCCESS;
            } catch (IOException e) {
                e.printStackTrace();
                response = PushConstants.ERROR;
            }


        return response;


    }

    @Override
    public String increaseVolume(VolumeEvent volumeEvent) {

        String response = PushConstants.ERROR;
        try {
            /*"amixer -D pulse sset Master 50%\n";*/
            Runtime.getRuntime().exec(new String[]{"amixer","-D","pulse","sset","Master", new StringBuilder("").append(volumeEvent.getVolumePercentage()).append("%").toString()});
            response = PushConstants.SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            response = PushConstants.ERROR;
        }


        return response;

    }

    @Override
    public String decreaseVolume(VolumeEvent volumeEvent) {
        return null;
    }


}
