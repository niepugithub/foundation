package com.algorithm;

import org.junit.Test;

/**
 * 最大子序列
 *
 * @date:2020/9/8 21:52
 **/
public class MaxSub {

    @Test
    public void maxSub1() {
        //int[] arr = {1, -3, 4, 1, 3, 5, 7, 1, -2, 1, -4, 5, -2, 3};
        int[] arr = {-1, -3, -4, -1, -3, -5, -7, -1, -2, -1, -4, -5, -2, -3};
        int maxSub = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            int sub = 0;
            for (int j = i; j < arr.length; j++) {
                sub += arr[j];
                if (maxSub < sub) {
                    maxSub = sub;
                    start = i;
                    end = j;
                }
            }
        }
        System.out.println(String.format("maxSub=%d,start=%d,end=%d", maxSub, start, end));
    }

    @Test
    public void maxSub2() {
        // int[] arr = {1, -3, 4, 1, 3, 5, 7, 1, -2, 1, -4, 5, -2, 3};
        int[] arr = {-1, -3, -4, -1, -3, -5, -7, -1, -2, -1, -4, -5, -2, -3};
        int maxSub = Integer.MIN_VALUE;
        int thisSum = 0;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum > maxSub) {
                maxSub = thisSum;
                end = i;
            } else if (thisSum < 0) {
                thisSum = 0;
                // 这里防止全是0的情况，end会等于arr.length
                start = i + 1 == arr.length ? 0 : i + 1;
            }
        }
        System.out.println(String.format("maxSub=%d,start=%d,end=%d", maxSub, start, end));
    }

}
