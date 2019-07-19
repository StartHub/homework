package com.dx.dky.other.sortArith;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author : dengxu
 * @create 2018-09-17 18:17
 **/
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {20, 87, 30, 4, 6, 9, 39, 67, 24};
        System.out.println(Arrays.toString(arr));
        int start = 0;
        int end = arr.length - 1;
        if (start > end) {
            return;
        }
        fastSort(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    private static void fastSort(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int key = arr[i];
        while (j > i) {

            while (j > i && arr[j] >= key) {
                j--;
            }

            if (arr[j] <= key) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            while (i < j && arr[i] <= key) {
                i++;
            }

            if (arr[i] >= key) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if (i > start) {
            fastSort(arr, start, i - 1);
        }

        if (j < end) {
            fastSort(arr, j + 1, end);
        }
    }
}
