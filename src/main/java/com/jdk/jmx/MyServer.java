package com.jdk.jmx;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

/**
 * @description:
 * @date:2020/10/7 17:15
 **/
@Setter
@Getter
public class MyServer {

    private int port;

    private String host;

    private int maxThread;

    private int minThread;

    @ConstructorProperties({"port", "host", "maxThread", "minThread"})
    public MyServer(int port, String host, int maxThread, int minThread) {
        this.port = port;
        this.host = host;
        this.maxThread = maxThread;
        this.minThread = minThread;
    }

}
