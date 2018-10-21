package com.study.java.io.serialize.saverule;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;


@WebService
public class HelloWorldWsImpl implements HelloWorldWs{

    public String sayHello(String name) {
        return "Hello "+name+"";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/demo/hello",new HelloWorldWsImpl());

        System.out.println("success");
    }
}
