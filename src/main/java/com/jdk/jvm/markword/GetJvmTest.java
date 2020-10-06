package com.jdk.jvm.markword;

import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @date:2020/10/6 14:24
 **/
public class GetJvmTest {

    public static void main(String[] args) {
        // 获取自己设置的jvm参数的方式
        final List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println(inputArguments);
        // -XX:hashCode，指定hashCode生成算法
        System.out.println(inputArguments.size());
    }

}
