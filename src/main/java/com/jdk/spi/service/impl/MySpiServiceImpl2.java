package com.jdk.spi.service.impl;

import com.jdk.spi.service.MySpiService;

/**
 * @date:2020/10/6 14:42
 **/
public class MySpiServiceImpl2 implements MySpiService {

    static {
        System.out.println("静态代码块执行了");
    }

    public MySpiServiceImpl2() {
        System.out.println("MySpiServiceImpl2222构造器");
    }

    @Override
    public String service(String param) {
        return "2222" + param;
    }

}
