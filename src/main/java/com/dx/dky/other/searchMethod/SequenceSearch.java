package com.dx.dky.other.searchMethod;

/**
 * 顺序查找算法
 *
 * @Author: dengxu
 * @Date: Created in 20:54 2018/9/6
 */
public class SequenceSearch {
    int[] data = {12, 45, 67, 32, 98, 5, 34};
    int searchNum = 32;
    int length = data.length - 1;

    public int search() {
        int i;
        for (i = 0; i < length; i++) {
            if (data[i] == searchNum) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequenceSearch search = new SequenceSearch();
        search.search();
    }
}
