package com.gyt.starter;


public class HelloService {

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    HelloProperties helloProperties;

    public String sayHello(String name) {
        return helloProperties.getPrefix() + "-" + name + helloProperties.getSuffix();
    }

}
