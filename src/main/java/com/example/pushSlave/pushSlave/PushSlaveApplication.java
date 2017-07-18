package com.example.pushSlave.pushSlave;

import com.example.pushSlave.pushSlave.Request.Consumer;
import com.example.pushSlave.pushSlave.pushUtil.RestUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

@SpringBootApplication
public class PushSlaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(PushSlaveApplication.class, args);

		try {
			String ip = null;
			String name = null;
			try(final DatagramSocket socket = new DatagramSocket()){
				socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
				ip = socket.getLocalAddress().getHostAddress();
				name = InetAddress.getLocalHost().getHostName();
			} catch (SocketException e) {
				e.printStackTrace();
			}
			if(ip==null){
				throw new  NullPointerException();
			}
			System.out.println(ip);
			Consumer consumer = new Consumer();
			consumer.setIp(ip.toString());
			consumer.setName(name);

			System.out.println(RestUtil.postConsumer("192.168.0.111", consumer));
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}

	}
}
