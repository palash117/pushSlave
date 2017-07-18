package com.example.pushSlave.pushSlave.service;


import com.example.pushSlave.pushSlave.event.impl.BasicEvent;

import java.net.URISyntaxException;
import java.util.Set;

/**
 * Created by palash on 11/7/17.
 */
public interface Servicable {

    public String  processEvent(BasicEvent event);
}
