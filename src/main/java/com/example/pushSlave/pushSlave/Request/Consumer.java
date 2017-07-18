package com.example.pushSlave.pushSlave.Request;


/**
 * Created by palash on 9/7/17.
 */
public class Consumer {
    @Override
    public String toString() {
        return "Consumer{" +
                "ip=" + ip +
                ", name='" + name + '\'' +
                '}';
    }

    public String ip;
    public String name;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
