package com.example.pushSlave.pushSlave.controller;


import com.example.pushSlave.pushSlave.event.impl.BasicEvent;

import java.util.Set;

/**
 * Created by palash on 9/7/17.
 */
public interface IController {

    public String health();

    public String pushEvent(BasicEvent event);

}
