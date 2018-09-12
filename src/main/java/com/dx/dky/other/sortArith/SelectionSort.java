package com.dx.dky.other.sortArith;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author : dengxu
 * @create 2018-09-12 15:26
 **/
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {66, 87, 30, 4, 6, 9, 39, 67, 24};
        System.out.println("交换之前：" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }

            if (i != k) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println("交换之后：" + Arrays.toString(arr));
    }
}
