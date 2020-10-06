package com.jdk.spi.service;

import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @date:2020/10/6 14:44
 **/
public class MySpiServiceTest {

    @Test
    public void test() {
        ServiceLoader<MySpiService> load = ServiceLoader.load(MySpiService.class);
        // 这里只是加载的话，不会实例化对象的，构造器没有执行
        System.out.println(load);
        Iterator<MySpiService> iterator = load.iterator();
        while (iterator.hasNext()) {
            System.out.println("-------------------");
            MySpiService next = iterator.next();
            System.out.println(next.service("11"));
        }

        // 注意META-INF/services目录以及方在resources目录下
        // 输出时序：由此可知，只有遍历ServiceLoader才会真正出发实例化对象的操作

        /**
         * java.util.ServiceLoader[com.jdk.spi.service.MySpiService]
         *-------------------
         *静态代码块执行了
         *MySpiServiceImpl1111构造器
         *111111
         *-------------------
         *静态代码块执行了
         *MySpiServiceImpl2222构造器
         *222211
         */
    }

}
