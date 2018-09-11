package com.dx.dky.other.searchMethod;

import java.util.Arrays;

/**
 * 插值查找
 * @Author: dengxu
 * @Date: Created in 21:43 2018/9/6
 */
public class InsertionSearch {

    public static int insertionSearch(int[] data, int key, int low, int high) {
        int mid = low + (key - data[low]) / (data[high] - data[low]) * (high - low);
        if (data[mid] == key) {
            return mid;
        } else if (data[mid] > key) {
            return insertionSearch(data, key, low, mid - 1);
        } else if (data[mid] < key)
            return insertionSearch(data, key, mid + 1, high);
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {12, 45, 67, 32, 98, 5, 34, 25, 47, 87, 18, 7};
        int key = 32;
        int low = 0;
        int high = data.length - 1;
        data = Arrays.stream(data).sorted().toArray();
        System.out.println(Arrays.toString(data));
        System.out.println(InsertionSearch.insertionSearch(data, key, low, high));
    }
}
