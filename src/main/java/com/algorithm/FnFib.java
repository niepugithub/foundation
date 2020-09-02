package com.algorithm;

import org.junit.Test;

/**
 * @date:2020/9/2 22:13
 **/
public class FnFib {


    @Test
    public void test1() {
        // 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
        // 45=1836311903
        long current = System.currentTimeMillis();
        System.out.println(m2(45L));
        long middle = System.currentTimeMillis();
        System.out.println(middle - current);
        System.out.println(m1(45L));
        System.out.println(System.currentTimeMillis() - middle);
    }

    public long m1(long n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return m1(n - 1) + m1(n - 2);
    }

    public long m2(long n) {
        int f1 = 1;
        int f2 = 1;
        for (int i = 1; i < n; i++) {
            f2 = f1 + f2;
            f1 = f2 - f1;
        }
        return f2;
    }

}
