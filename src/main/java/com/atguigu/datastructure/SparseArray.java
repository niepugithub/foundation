package com.atguigu.datastructure;

import org.junit.Test;

import java.util.Arrays;

/**
 * @date:2020/9/1 21:16
 **/
public class SparseArray {


    @Test
    public void toArray() {
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[2][4] = 2;

        Arrays.stream(chessArr).forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });

        System.out.println("--------------------------------------------");

        int sum = 0;
        for (int[] arr : chessArr) {
            for (int i : arr) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        // 计算sum的值，得到稀疏数组的行数
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessArr.length;
        sparseArray[0][1] = chessArr[0].length;
        sparseArray[0][2] = sum;
        int line = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArray[line][0] = i;
                    sparseArray[line][1] = j;
                    sparseArray[line][2] = chessArr[i][j];
                    line++;
                }
            }

        }

        System.out.println("得到的稀疏数组---------------");
        Arrays.stream(sparseArray).forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });


        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int[][] target = new int[row][col];

        for (int i = 1; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[0].length; j++) {
                target[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            }
        }
        System.out.println("还原稀疏数组---------------");
        Arrays.stream(target).forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });
    }


}
