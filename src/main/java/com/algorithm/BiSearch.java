package com.algorithm;

import org.junit.Test;

/**
 * @date:2020/9/12 13:42
 **/
public class BiSearch {


    @Test
    public void biSearch() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        int value = -2;
        System.out.println(bi1(arr, 0, arr.length - 1, value));

        System.out.println(bi2(arr, value));
    }

    public int bi1(int arr[], int start, int end, int value) {
        int middle = (start + end) / 2;
        if (end < start) {
            return -1;
        }
        if (arr[middle] > value) {
            return bi1(arr, start, middle - 1, value);
        } else if (arr[middle] < value) {
            return bi1(arr, middle + 1, end, value);
        } else {
            return middle;
        }
    }

    public int bi2(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] > value) {
                high = middle - 1;
            } else if (arr[middle] < value) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
