package com.dx.dky.other.sortArith;

import java.util.Arrays;

/**
 * 插值排序
 *
 * @author : dengxu
 * @create 2018-09-12 17:01
 **/
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {66, 87, 30, 4, 6, 9, 39, 67, 24};
        System.out.println("交换之前：" + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                // 内循环局部元素比较
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println("交换之后：" + Arrays.toString(arr));
    }
}
