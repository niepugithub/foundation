package com.jdk.jvm.markword;

import org.openjdk.jol.info.ClassLayout;

/**
 * mark word 在加锁前后会发生变化，但是hashCode值却不变
 *
 * @date:2020/10/6 14:24
 **/
public class MarkWordTest {

    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println("obj-hashCode: " + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("-------------------------------------------");

        synchronized (obj) {
            System.out.println("obj-hashCode: " + Integer.toHexString(obj.hashCode()));
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            System.out.println("-------------------------------------------");
        }

        System.out.println("obj-hashCode: " + Integer.toHexString(System.identityHashCode(obj)));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("-------------------------------------------");
    }

}
