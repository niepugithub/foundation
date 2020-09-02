package com.algorithm;

import org.junit.Test;

/**
 * @date:2020/9/2 21:44
 **/
public class SqrtRoot {

    @Test
    public void sqrt() {

        int y = 5;
        double x = 2.0;
        while (Math.abs((x * x - y)) > 0.00000000000001) {
            x = (x + y / x) / 2;
        }
        System.out.println(x);

    }

}
