package com.algorithm;

import org.junit.Test;

/**
 * @date:2020/9/8 21:36
 **/
public class KmaxValue {

    /**
     * 获取第k大的元素
     */
    @Test
    public void k1() {
        int[] arr = {-1, 1, 9, 6, 5, 3, 4, 2, 8, 7, 0};
        // -1,0,1,2,3,4,5,6,7,8,9
        System.out.println(getK1(6, arr));
    }

    public int getK1(int k, int[] arr) {

        if (k > arr.length || k < 0) {
            throw new RuntimeException("k值不合法，大于数组长度" + arr.length + "或者小于0");
        }
        if (k == 0) {
            return arr[0];
        }

        int[] result = new int[k];
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // result中已经存在k个值了并且最后一个值还比当前的arr[i]大，结束当次循环
            if (i >= k && arr[i] < result[k - 1]) {
                // 新的arr[i]比result的最后一个元素要小，忽略
                continue;
            } else {
                // result中还没有k个元素，找到arr[i]在result中的正确位置
                // 遍历result，将arr[i]插入到正确的位置，将result中剩下的元素后移，溢出不管
                findIndex(result, arr[i]);
            }

        }
        return result[k - 1];
    }

    private void findIndex(int[] result, int ele) {
        for (int index = 0; index < result.length; index++) {
            if (ele > result[index]) {
                for (int j = result.length; j > index + 1; j--) {
                    result[j - 1] = result[j - 2];
                }
                result[index] = ele;
                break;
            }
        }
    }

}
