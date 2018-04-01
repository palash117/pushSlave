package com.example.pushSlave.pushSlave.controller.impl;

import com.example.pushSlave.pushSlave.controller.IController;
import com.example.pushSlave.pushSlave.event.impl.BasicEvent;
import com.example.pushSlave.pushSlave.event.impl.VolumeEvent;
import com.example.pushSlave.pushSlave.service.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by palash on 9/7/17.
 */
@RestController
public class BasicController implements IController {


    @Autowired
    Servicable service;


    @RequestMapping(value="/",method= RequestMethod.GET)
    @Override
    public String health() {
        return "API IS UP";
    }


    @RequestMapping("/pushEvent")
    @Override
    public String pushEvent( @RequestBody BasicEvent event) {

       return  service.processEvent(event);
    }


    @RequestMapping("/changeVolume")
    @Override
    public String changeVolume(@RequestBody VolumeEvent volumeEvent) {
        try{

            System.out.println(volumeEvent.toString());
            return  service.changeVolume(volumeEvent);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "ok";
    }
}
