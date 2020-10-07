package com.jdk.jmx;

/**
 * @description:
 * @date:2020/10/7 18:09
 **/
public class MyServerManagement implements MyServerMXBean {

    private MyServer server;

    public MyServerManagement(MyServer server) {
        this.server = server;
    }

    public MyServer getServer() {
        return this.server;
    }

    @Override
    public int getPort() {
        return this.server.getPort();
    }

    @Override
    public String getHost() {
        return this.server.getHost();
    }

    @Override
    public int getMaxThread() {
        return this.server.getMaxThread();
    }

    @Override
    public int getMinThread() {
        return this.server.getMinThread();
    }
}
