package com.dx.dky.other.sortArith;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author : dengxu
 * @create 2018-09-12 15:26
 **/
public class BubbleSort {


    public static void main(String[] args) {

        int[] arr = {66, 87, 30, 4, 6, 9, 39, 67, 24};
        System.out.println("交换之前：" + Arrays.toString(arr));
        //外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("交换之后：" + Arrays.toString(arr));
    }
}
