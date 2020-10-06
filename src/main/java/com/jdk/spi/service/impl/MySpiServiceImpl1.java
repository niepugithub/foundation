package com.jdk.spi.service.impl;

import com.jdk.spi.service.MySpiService;

/**
 * @date:2020/10/6 14:41
 **/
public class MySpiServiceImpl1 implements MySpiService {

    static {
        System.out.println("静态代码块执行了");
    }

    public MySpiServiceImpl1() {
        System.out.println("MySpiServiceImpl1111构造器");
    }

    @Override
    public String service(String param) {
        return "1111" + param;
    }

}
