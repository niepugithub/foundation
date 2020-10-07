package com.jdk.jmx;

/**
 * @description:
 * @date:2020/10/7 18:06
 **/
public interface MyServerMXBean {

    /**
     * 端口号
     *
     * @return
     */
    int getPort();

    /**
     * 主机名
     *
     * @return
     */
    String getHost();

    /**
     * 最大线程数
     *
     * @return
     */
    int getMaxThread();

    /**
     * 最小线程数
     *
     * @return
     */
    int getMinThread();

}
