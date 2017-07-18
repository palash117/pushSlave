package com.example.pushSlave.pushSlave.pushUtil;

import com.example.pushSlave.pushSlave.Request.Consumer;
import com.example.pushSlave.pushSlave.event.Eventable;
import com.example.pushSlave.pushSlave.pushConstants.PushConstants;
import com.sun.javafx.fxml.builder.URLBuilder;
import jdk.nashorn.internal.runtime.URIUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * Created by palash on 17/7/17.
 */
public class RestUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    public static String postPushEvent(String ip, Eventable event){
        String response = new String();

        URI uri = null;
        try {
            uri = new URI(ip + ":8080/pushEvent");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return  PushConstants.ERROR;

        }

        response = restTemplate.getForObject( uri, String.class);

        return response;
    }


    public static String postConsumer(String ip, Consumer consumer){
        String response = new String();

        URI uri = null;
        try {
            String protocol = "http";
            String host = ip;
            int port = 8080;
            String path = "/addConsumer";
            String auth = null;
            String fragment = null;
            uri = new URI(protocol, auth, host, port, path, null, fragment);

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return  PushConstants.ERROR;

        }

        response = restTemplate.postForObject(uri, consumer, String.class);

        return response;
    }

}
